package net.unicoen.unimappergenerator.tests

import javax.inject.Inject
import net.unicoen.UniMapperGeneratorInjectorProvider
import net.unicoen.uniMapperGenerator.Grammar
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import net.unicoen.generator.UniMapperGeneratorGenerator

@RunWith(XtextRunner)
@InjectWith(UniMapperGeneratorInjectorProvider)
class SimpleParsingTest {

	@Inject extension ParseHelper<Grammar>

	@Test def void testParse() {
		val grammars = '''
grammar Test;
root literal;

literal
	:	'boolean'
	;

literal2
	:	'boolean2'
	;
		'''.parse
		assertEquals(2, grammars.rules.size)
	}

	@Test def void testHasField() {
		val generator = new UniMapperGeneratorGenerator
		assertTrue(generator.hasField("UniClassDec", "className"))
		assertTrue(generator.hasField("UniFieldDec", "value"))
		assertFalse(generator.hasField("UniBoolLiteral", "block"))
	}
}
