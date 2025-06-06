// Grammar created by: Hussein Abdul-Ameer

grammar vg_lang;
program
    : statement* EOF
    ;

statement
    : variableDeclaration
    | assignment
    | printStatement
    | comments
    | ifStatement
    | expressionStatement
    | constDeclaration
    | forStatement
    | functionDeclaration
    | returnStatement
    | tryStatement
    | throwStatement
    | whileStatement
    | doWhileStatement
    | libraryDeclaration
    | importStatement
    | structDeclaration
    | enumDeclaration
    ;

        importStatement
            : 'import' importPath ';'
            ;

        importPath
            : IDENTIFIER ('.' IDENTIFIER)* ('.' '*')?
            ;

        libraryDeclaration
            : 'library' IDENTIFIER '{' namespaceDeclaration* '}'
            ;

        namespaceDeclaration
            : 'namespace' IDENTIFIER '{' (functionDeclaration | variableDeclaration | constDeclaration| namespaceDeclaration)* '}'
            ;


    functionDeclaration
        : 'function' IDENTIFIER '(' parameterList? ')' block
        ;


    parameterList
        : IDENTIFIER (',' IDENTIFIER)*
        ;

    returnStatement
        : 'return' expression? ';'
        ;

    forStatement
        : 'for' '(' forInit? ';' forCondition? ';' forUpdate? ')' block
        ;

    forInit
        : variableDeclarationNoSemi
        | assignmentNoSemi
        ;

    forCondition
        : expression
        ;

    forUpdate
        : assignmentNoSemi
        ;
whileStatement
    : 'while' '(' expression ')' block
    ;
doWhileStatement
    : 'do' block 'while' '(' expression ')' ';'
    ;


arrayLiteral
    : '[' (expression (',' expression)*)? ']'
    ;

variableDeclaration
    : 'var' IDENTIFIER '=' expression ';'
    ;
variableDeclarationNoSemi
    : 'var' IDENTIFIER '=' expression
    ;
constDeclaration
   : 'const' IDENTIFIER '=' expression ';'
   ;
assignment
    : leftHandSide '=' expression ';'
    ;
assignmentNoSemi
    : leftHandSide '=' expression
    ;
leftHandSide
    : IDENTIFIER ( '[' expression ']' )*
    | IDENTIFIER '.' IDENTIFIER
    ;
printStatement
    : 'print' '(' expression (',' expression)* ')' ';'
    ;
expression
    : logicalOrExpression
     | functionReference
    ;
functionReference
    : '&' qualifiedIdentifier '(' argumentList? ')'
    ;
    qualifiedIdentifier
        : IDENTIFIER ('.' IDENTIFIER)*
        ;
logicalOrExpression
    : logicalAndExpression ( '||' logicalAndExpression )*
    ;

logicalAndExpression
    : equalityExpression ( '&&' equalityExpression )*
    ;

equalityExpression
    : relationalExpression ( ( '==' | '!=' ) relationalExpression )*
    ;

relationalExpression
    : additiveExpression ( ( '<' | '<=' | '>' | '>=' ) additiveExpression )*
    ;

additiveExpression
    : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
    ;

multiplicativeExpression
    : unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )*
    ;

unaryExpression
    : ( '+' | '-' | '!' ) unaryExpression
    | postfixExpression
    ;

ifStatement
    : 'if' '(' expression ')' ifBlock=block elseIfStatement* elseStatement?
    ;

elseIfStatement
    : 'else' 'if' '(' expression ')' block
    ;

elseStatement
    : 'else' block
    ;
    structDeclaration
        : 'struct' IDENTIFIER '{' structField* '}'
        ;

    structField
        : IDENTIFIER ';'
        ;

    enumDeclaration
        : 'enum' IDENTIFIER '{' enumValue (',' enumValue)* '}'
        ;
        enumValue
            : IDENTIFIER ('=' expression)?
            ;
block
    : '{' statement* '}'
    ;

postfixExpression
    : primary (postfixOp)*
    ;

postfixOp
    : '.' IDENTIFIER
    | '(' argumentList? ')'
    | '[' expression ']'
    ;
 primary : literal
    | IDENTIFIER
    | '(' expression ')'
    | functionCall

    ;

    functionCall
        : (IDENTIFIER) '(' argumentList? ')'
        ;


    argumentList
        : expression (',' expression)*
        ;

tryStatement
    : 'try' block catchStatement+ finallyStatement?
    ;

catchStatement
    : 'catch' '(' IDENTIFIER ')' block
    ;

finallyStatement
    : 'finally' block
    ;

throwStatement
    : 'throw' expression ';'
    ;


 literal
     : INT
     | DOUBLE
     | STRING_LITERAL
     | arrayLiteral
     | TRUE
     | FALSE
     ;
expressionStatement
    : expression ';'
    ;
comments
    : SINGLE_LINE_COMMENT
    | MULTI_LINE_COMMENT
    | DOC_COMMENT
    ;


fragment DOC_START : '/##';
fragment DOC_END : '##/';

DOC_COMMENT
    : DOC_START .*? DOC_END -> skip
    ;

SINGLE_LINE_COMMENT
    : '##' ~[\r\n]* -> skip
    ;

MULTI_LINE_COMMENT
    : '/#' .*? '#/' -> skip
    ;

IDENTIFIER
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;
TRUE    : 'true';
FALSE   : 'false';
INT : [0-9]+
    ;

DOUBLE: [0-9]+ '.' [0-9]+
    ;

STRING_LITERAL: '"' ( ESC_SEQ | ~["\\\r\n] )* '"'
    ;

fragment ESC_SEQ
    : '\\' [btnfr"\\]
    | UNICODE_ESC
    ;

fragment UNICODE_ESC
    : '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

fragment HEX_DIGIT
    : [0-9a-fA-F]
    ;
WS
    : [ \t\r\n]+ -> skip
    ;