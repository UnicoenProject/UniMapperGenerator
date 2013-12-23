/*
* generated by Xtext
*/
package org.xtext.example.mydsl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.xtext.example.mydsl.services.MyDslGrammarAccess;

public class MyDslParser extends AbstractContentAssistParser {
	
	@Inject
	private MyDslGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.xtext.example.mydsl.ui.contentassist.antlr.internal.InternalMyDslParser createParser() {
		org.xtext.example.mydsl.ui.contentassist.antlr.internal.InternalMyDslParser result = new org.xtext.example.mydsl.ui.contentassist.antlr.internal.InternalMyDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getTermAccess().getAlternatives(), "rule__Term__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getGrammarAccess().getGroup(), "rule__Grammar__Group__0");
					put(grammarAccess.getRuleAccess().getGroup(), "rule__Rule__Group__0");
					put(grammarAccess.getExpressionAccess().getGroup(), "rule__Expression__Group__0");
					put(grammarAccess.getExpressionAccess().getGroup_1(), "rule__Expression__Group_1__0");
					put(grammarAccess.getKeyConstrAccess().getGroup(), "rule__KeyConstr__Group__0");
					put(grammarAccess.getKeyConstrAccess().getGroup_1(), "rule__KeyConstr__Group_1__0");
					put(grammarAccess.getRuleCallAccess().getGroup(), "rule__RuleCall__Group__0");
					put(grammarAccess.getModelAccess().getGramAssignment_0(), "rule__Model__GramAssignment_0");
					put(grammarAccess.getModelAccess().getRulesAssignment_1(), "rule__Model__RulesAssignment_1");
					put(grammarAccess.getGrammarAccess().getGnameAssignment_1(), "rule__Grammar__GnameAssignment_1");
					put(grammarAccess.getRuleAccess().getNameAssignment_1(), "rule__Rule__NameAssignment_1");
					put(grammarAccess.getRuleAccess().getExpressionAssignment_4(), "rule__Rule__ExpressionAssignment_4");
					put(grammarAccess.getExpressionAccess().getElementsAssignment_0(), "rule__Expression__ElementsAssignment_0");
					put(grammarAccess.getExpressionAccess().getElementsAssignment_1_1(), "rule__Expression__ElementsAssignment_1_1");
					put(grammarAccess.getElementAccess().getTermsAssignment(), "rule__Element__TermsAssignment");
					put(grammarAccess.getTermAccess().getKConstrAssignment_0(), "rule__Term__KConstrAssignment_0");
					put(grammarAccess.getTermAccess().getRCallAssignment_1(), "rule__Term__RCallAssignment_1");
					put(grammarAccess.getKeyConstrAccess().getKwordAssignment_0(), "rule__KeyConstr__KwordAssignment_0");
					put(grammarAccess.getKeyConstrAccess().getKwordAssignment_1_1(), "rule__KeyConstr__KwordAssignment_1_1");
					put(grammarAccess.getKeywordAccess().getTextAssignment(), "rule__Keyword__TextAssignment");
					put(grammarAccess.getRuleCallAccess().getRefAssignment_1(), "rule__RuleCall__RefAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.xtext.example.mydsl.ui.contentassist.antlr.internal.InternalMyDslParser typedParser = (org.xtext.example.mydsl.ui.contentassist.antlr.internal.InternalMyDslParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public MyDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(MyDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
