// Generated from ProjGram.g4 by ANTLR 4.13.2
package compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Stack;
	import compiler.core.types.*;
	import compiler.core.ast.*;
	import compiler.core.exceptions.*;
	import compiler.core.expressions.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProjGramParser}.
 */
public interface ProjGramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ProjGramParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ProjGramParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#declare_var}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_var(ProjGramParser.Declare_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#declare_var}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_var(ProjGramParser.Declare_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(ProjGramParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(ProjGramParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(ProjGramParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(ProjGramParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(ProjGramParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(ProjGramParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#cmdComment}.
	 * @param ctx the parse tree
	 */
	void enterCmdComment(ProjGramParser.CmdCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#cmdComment}.
	 * @param ctx the parse tree
	 */
	void exitCmdComment(ProjGramParser.CmdCommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttrib(ProjGramParser.CmdAttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttrib(ProjGramParser.CmdAttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void enterCmdRead(ProjGramParser.CmdReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void exitCmdRead(ProjGramParser.CmdReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void enterCmdWrite(ProjGramParser.CmdWriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void exitCmdWrite(ProjGramParser.CmdWriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#cmdWrite_ln}.
	 * @param ctx the parse tree
	 */
	void enterCmdWrite_ln(ProjGramParser.CmdWrite_lnContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#cmdWrite_ln}.
	 * @param ctx the parse tree
	 */
	void exitCmdWrite_ln(ProjGramParser.CmdWrite_lnContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(ProjGramParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(ProjGramParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(ProjGramParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(ProjGramParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ProjGramParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ProjGramParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ProjGramParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ProjGramParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#expression_md}.
	 * @param ctx the parse tree
	 */
	void enterExpression_md(ProjGramParser.Expression_mdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#expression_md}.
	 * @param ctx the parse tree
	 */
	void exitExpression_md(ProjGramParser.Expression_mdContext ctx);
}