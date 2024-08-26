// Generated from ProjGram.g4 by ANTLR 4.13.2
package compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import compiler.core.types.*;

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
	 * Enter a parse tree produced by {@link ProjGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ProjGramParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ProjGramParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(ProjGramParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(ProjGramParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#expr_md}.
	 * @param ctx the parse tree
	 */
	void enterExpr_md(ProjGramParser.Expr_mdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#expr_md}.
	 * @param ctx the parse tree
	 */
	void exitExpr_md(ProjGramParser.Expr_mdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#repetition}.
	 * @param ctx the parse tree
	 */
	void enterRepetition(ProjGramParser.RepetitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#repetition}.
	 * @param ctx the parse tree
	 */
	void exitRepetition(ProjGramParser.RepetitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjGramParser#instruction_block}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_block(ProjGramParser.Instruction_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjGramParser#instruction_block}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_block(ProjGramParser.Instruction_blockContext ctx);
}