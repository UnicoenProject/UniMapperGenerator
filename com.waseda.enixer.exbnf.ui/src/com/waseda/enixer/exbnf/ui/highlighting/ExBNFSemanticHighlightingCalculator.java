package com.waseda.enixer.exbnf.ui.highlighting;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

import com.waseda.enixer.exbnf.exBNF.ElementWithDollar;
import com.waseda.enixer.exbnf.exBNF.ExBNFPackage;

public class ExBNFSemanticHighlightingCalculator implements
		ISemanticHighlightingCalculator {

	private final String[] KEYWORDS = { "MERGE", "RETURN", "ADD", "APPEND",
			"TODO" };

	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		if (resource == null) {
			return;
		}

		for (Iterator<EObject> i = EcoreUtil.getAllContents(resource, true); i
				.hasNext();) {
			EObject current = i.next();
			if (current instanceof ElementWithDollar) {
				List<INode> list = NodeModelUtils.findNodesForFeature(current,
						ExBNFPackage.Literals.ELEMENT_WITH_DOLLAR__OP);
				for (INode n : list) {
					if (isKeyword(n.getText())) {
						acceptor.addPosition(n.getOffset(), n.getLength(),
								DefaultHighlightingConfiguration.KEYWORD_ID);
					} else {
						acceptor.addPosition(n.getOffset(), n.getLength(),
								DefaultHighlightingConfiguration.STRING_ID);
					}
				}
			}
		}
	}

	private boolean isKeyword(String text) {
		for (String key : KEYWORDS) {
			if (key.equals(text)) {
				return true;
			}
		}
		return false;
	}
}
