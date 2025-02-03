// Generated from C:/Users/hodif/Desktop/usn2024/vg lang/grammar/vg_lang.g4 by ANTLR 4.13.2
package components;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link vg_langParser}.
 */
public interface vg_langListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link vg_langParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(vg_langParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(vg_langParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(vg_langParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(vg_langParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(vg_langParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(vg_langParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(vg_langParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(vg_langParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(vg_langParser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(vg_langParser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(vg_langParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(vg_langParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(vg_langParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(vg_langParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(vg_langParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(vg_langParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(vg_langParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(vg_langParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(vg_langParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(vg_langParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(vg_langParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(vg_langParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(vg_langParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(vg_langParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(vg_langParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(vg_langParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(vg_langParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(vg_langParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(vg_langParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(vg_langParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(vg_langParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(vg_langParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(vg_langParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(vg_langParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(vg_langParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(vg_langParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link vg_langParser#comments}.
	 * @param ctx the parse tree
	 */
	void enterComments(vg_langParser.CommentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link vg_langParser#comments}.
	 * @param ctx the parse tree
	 */
	void exitComments(vg_langParser.CommentsContext ctx);
}