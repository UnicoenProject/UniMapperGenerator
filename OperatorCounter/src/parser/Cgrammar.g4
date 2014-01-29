grammar Cgrammar;

translation_unit:
	external_declaration ;
external_declaration:
	function_definition | declaration ;
function_definition:
	declaration_specifiers declarator declaration_list compound_statement | declaration_specifiers declarator compound_statement | declarator declaration_list compound_statement | declarator compound_statement ;
primary_expression:
	identifier | CONSTANT | LPAREN expression RPAREN ;
postfix_expression:
	primary_expression | postfix_expression INCORDEC ;
unary_expression:
	postfix_expression | INCORDEC unary_expression | UNARY_OPERATOR unary_expression ;
multiplicative_expression:
	unary_expression | multiplicative_expression MULTIPLICATION unary_expression ;
additive_expression:
	multiplicative_expression | additive_expression UNARY_OPERATOR multiplicative_expression ;
shift_expression:
	additive_expression ;
relational_expression:
	shift_expression | relational_expression RELATION shift_expression ;
equality_expression:
	relational_expression | equality_expression EQUAL relational_expression ;
and_expression:
	equality_expression ;
exclusive_or_expression:
	and_expression ;
inclusive_or_expression:
	exclusive_or_expression ;
logical_and_expression:
	inclusive_or_expression | logical_and_expression AND inclusive_or_expression ;
logical_or_expression:
	logical_and_expression | logical_or_expression OR logical_and_expression ;
conditional_expression:
	logical_or_expression ;
assignment_expression:
	conditional_expression | unary_expression ASSIGNMENT_OPERATOR assignment_expression ;
expression:
	assignment_expression | expression COMMA assignment_expression ;
declaration:
	declaration_specifiers SEMICOLON | declaration_specifiers init_declarator_list SEMICOLON ;
declaration_specifiers:
	TYPE_SPECIFIER ;
init_declarator_list:
	init_declarator | init_declarator_list COMMA init_declarator ;
init_declarator:
	declarator | declarator SUBSTITUTION initializer ;
declarator:
	direct_declarator ;
direct_declarator:
	identifier | LPAREN declarator RPAREN | direct_declarator LPAREN parameter_type_list RPAREN | direct_declarator LPAREN identifier_list RPAREN | direct_declarator LPAREN RPAREN ;
parameter_type_list:
	parameter_list ;
parameter_list:
	parameter_declaration | parameter_list COMMA parameter_declaration ;
parameter_declaration:
	declaration_specifiers declarator | declaration_specifiers ;
identifier_list:
	identifier | identifier_list COMMA identifier ;
initializer:
	assignment_expression | LBRACKET initializer_list RBRACKET | LBRACKET initializer_list COMMA RBRACKET ;
initializer_list:
	initializer | initializer_list COMMA initializer ;
statement:
	compound_statement | expression_statement | selection_statement | iteration_statement ;
compound_statement:
	LBRACKET RBRACKET | LBRACKET statement_list RBRACKET | LBRACKET declaration_list RBRACKET | LBRACKET declaration_list statement_list RBRACKET ;
declaration_list:
	declaration | declaration_list declaration ;
statement_list:
	statement | statement_list statement ;
expression_statement:
	SEMICOLON | expression SEMICOLON ;
selection_statement:
	IF LPAREN expression RPAREN statement | IF LPAREN expression RPAREN statement ELSE statement ;
iteration_statement:
	WHILE LPAREN expression RPAREN statement | DO statement WHILE LPAREN expression RPAREN SEMICOLON | FOR LPAREN expression_statement expression_statement expression RPAREN statement ;
identifier:
	CHARACTERS | CHARACTERS identifier ;

LPAREN:
	'(' ;
RPAREN:
	')' ;
LBRACKET:
	'{' ;
RBRACKET:
	'}' ;
SUBSTITUTION:
	'=' ;
UNARY_OPERATOR:
	'+' | '-' ;
MULTIPLICATION:
	'*' | '/' | '%' ;
INCORDEC:
	'++' | '--' ;
RELATION:
	'<' | '>' | '<=' | '>=' ;
EQUAL:
	'==' | '!=' ;
AND:
	'&&' ;
OR:
	'||' ;
ASSIGNMENT_OPERATOR:
	'=' | '/=' | '+=' | '-=' | '%=' ;
COMMA:
	',' ;
SEMICOLON:
	';' ;
TYPE_SPECIFIER:
	'int' | 'long' | 'float' | 'double' | 'void' ;
IF:
	'if' ;
ELSE:
	'else' ;
WHILE:
	'while' ;
DO:
	'do' ;
FOR:
	'for' ;
CHARACTERS:
	'a' .. 'z' | 'A' .. 'Z' ;
CONSTANT:
	'0' .. '9' ;

Whitespace:
	[ \r\n\t] -> skip;