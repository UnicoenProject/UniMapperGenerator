package net.unicoen.generator

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess

class MapperGenerator implements IGenerator{
	
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		fsa.generateFile("sample.txt", "aaa")
	}
	
}