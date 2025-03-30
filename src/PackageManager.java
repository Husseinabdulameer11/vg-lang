import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class  PackageManager {
    private static final String REPO_URL = "https://raw.githubusercontent.com/Husseinabdulameer11/vg-lang-packagemanager/main/packages.json";
    private static final String PACKAGES_PATH = "packages/";

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println(" vgpkg <Command> [PackageName]");
            System.out.println("Example: vgpkg install mathlib");
            return;
        }

        String command = args[0];
        switch (command) {
            case "install":
                if (args.length < 2) {
                    System.out.println("Missing PackageName: vgpkg install <PackageName>");
                } else {
                    installPackage(args[1]);
                }
                break;
            case "remove":
                if (args.length < 2) {
                    System.out.println("Missing PackageName: vgpkg remove <PackageName>");
                } else {
                    removePackage(args[1]);
                }
                break;
            case "list":
                listInstalledPackages();
                break;
            case "available":
                listAvailablePackages();
                break;
            default:
                System.out.println("Unkown Command: " + command);
                System.out.println("Available Commands: install, remove, list");
        }
    }
    private static String getFileNameFromUrl(String url) {
        int lastSlash = url.lastIndexOf('/');
        if (lastSlash == -1) {
            return url;
        }
        return url.substring(lastSlash + 1);
    }

    public static void installPackage(String packageName) throws Exception {

        String jsonStr = readFromURL(REPO_URL);
        JSONObject json = new JSONObject(jsonStr);
        JSONArray pkgArray = json.getJSONArray("packages");


        for (int i = 0; i < pkgArray.length(); i++) {
            JSONObject pkg = pkgArray.getJSONObject(i);
            if (pkg.getString("name").equals(packageName)) {
                String url = pkg.getString("url");

                String fileName = getFileNameFromUrl(url);

                downloadFile(url, PACKAGES_PATH + fileName);

                System.out.println("Installed " + packageName);
                return;
            }
        }
        System.out.println("Package not found '" + packageName + "' i " + REPO_URL);
    }

    public static void removePackage(String packageName) throws IOException {
        File libDir = new File(PACKAGES_PATH);
        if (!libDir.exists()) {
            System.out.println("Libraries Folder not found");
            return;
        }

        File[] files = libDir.listFiles();
        boolean removed = false;

        if (files != null) {
            for (File file : files) {

                if (file.getName().equals(packageName + ".vglib")) {
                    Files.delete(file.toPath());
                    removed = true;
                    System.out.println("Removed " + file.getName());
                    break;
                }
            }
        }

        if (!removed) {
            System.out.println("No Packages found with the name:  " + packageName);
        }
    }


    public static void listInstalledPackages() {
        File libDir = new File(PACKAGES_PATH);
        if (!libDir.exists()) {
            System.out.println("No packages Installed.");
            return;
        }
        File[] files = libDir.listFiles((dir, name) -> name.endsWith(".vglib"));
        if (files == null || files.length == 0) {
            System.out.println("No packages Installed.");
            return;
        }
        for (File f : files) {
            System.out.println(f.getName());
        }
    }


    private static String readFromURL(String urlString) throws Exception {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(urlString);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

    private static void downloadFile(String urlString, String filePath) throws Exception {
        URL url = new URL(urlString);
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        }
    }
    public static void listAvailablePackages() throws Exception {
        String jsonStr = readFromURL(REPO_URL);
        JSONObject json = new JSONObject(jsonStr);
        JSONArray pkgArray = json.getJSONArray("packages");

        System.out.println("Available packages:");
        for (int i = 0; i < pkgArray.length(); i++) {
            JSONObject pkg = pkgArray.getJSONObject(i);
            System.out.println("- " + pkg.getString("name"));
        }
    }
}
