package net.unicoen.generator

import net.unicoen.uniMapperGenerator.Grammar
import org.eclipse.xtext.generator.IFileSystemAccess

class MapperTestGenerator {
	private IFileSystemAccess _fsa
	private val ext = "MapperTest.xtend"

	new(IFileSystemAccess fsa) {
		_fsa = fsa
	}

	def generate(String grammarName, Grammar grammar) {
		_fsa.generateFile(grammarName + ext, grammar.generateMapperTestTemplate(grammarName))
	}

	def generateMapperTestTemplate(Grammar g, String grammarName) '''package net.unicoen.mapper

import org.junit.Test
import static org.hamcrest.Matchers.*
import static org.junit.Assert.*

class «grammarName»MapperTest {
	val mapper = new «grammarName»Mapper(true)

	@Test
	def «grammarName»Test(){
		
	}

}
	'''

}