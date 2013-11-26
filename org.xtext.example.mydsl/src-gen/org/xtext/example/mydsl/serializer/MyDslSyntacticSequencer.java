package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MyDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_BracketsExp_LeftParenthesisKeyword_0_0_0_or_LeftSquareBracketKeyword_0_1_0;
	protected AbstractElementAlias match_BracketsExp___AsteriskKeyword_1_1_or_PlusSignKeyword_1_0__q;
	protected AbstractElementAlias match_Keyword_QuestionMarkKeyword_1_q;
	protected AbstractElementAlias match_RuleCall___AsteriskKeyword_1_1_or_PlusSignKeyword_1_0__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MyDslGrammarAccess) access;
		match_BracketsExp_LeftParenthesisKeyword_0_0_0_or_LeftSquareBracketKeyword_0_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getBracketsExpAccess().getLeftParenthesisKeyword_0_0_0()), new TokenAlias(false, false, grammarAccess.getBracketsExpAccess().getLeftSquareBracketKeyword_0_1_0()));
		match_BracketsExp___AsteriskKeyword_1_1_or_PlusSignKeyword_1_0__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getBracketsExpAccess().getAsteriskKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getBracketsExpAccess().getPlusSignKeyword_1_0()));
		match_Keyword_QuestionMarkKeyword_1_q = new TokenAlias(false, true, grammarAccess.getKeywordAccess().getQuestionMarkKeyword_1());
		match_RuleCall___AsteriskKeyword_1_1_or_PlusSignKeyword_1_0__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getRuleCallAccess().getAsteriskKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getRuleCallAccess().getPlusSignKeyword_1_0()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_BracketsExp_LeftParenthesisKeyword_0_0_0_or_LeftSquareBracketKeyword_0_1_0.equals(syntax))
				emit_BracketsExp_LeftParenthesisKeyword_0_0_0_or_LeftSquareBracketKeyword_0_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_BracketsExp___AsteriskKeyword_1_1_or_PlusSignKeyword_1_0__q.equals(syntax))
				emit_BracketsExp___AsteriskKeyword_1_1_or_PlusSignKeyword_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Keyword_QuestionMarkKeyword_1_q.equals(syntax))
				emit_Keyword_QuestionMarkKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_RuleCall___AsteriskKeyword_1_1_or_PlusSignKeyword_1_0__q.equals(syntax))
				emit_RuleCall___AsteriskKeyword_1_1_or_PlusSignKeyword_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '[' | '('
	 */
	protected void emit_BracketsExp_LeftParenthesisKeyword_0_0_0_or_LeftSquareBracketKeyword_0_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('*' | '+')?
	 */
	protected void emit_BracketsExp___AsteriskKeyword_1_1_or_PlusSignKeyword_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '?'?
	 */
	protected void emit_Keyword_QuestionMarkKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('*' | '+')?
	 */
	protected void emit_RuleCall___AsteriskKeyword_1_1_or_PlusSignKeyword_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
