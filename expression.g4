grammar expression;

expression:
	term | term (PM{System.out.println($e.text);}) e=expression ;
term:
	atom | atom matom ;
matom:
	Star atom ;
atom:
	integer | Lparen expression Rparen ;
integer:
	Number | Number integer ;
	
PM:
	'+'|'-';
Star:
	'*';
Lparen:
	'(';
Rparen:
	')';
Number:
	'0'..'9';

Whitespace:
	[ \r\n\t] -> skip;