grammar Expr;
prog: (expr NEWLINE)* ;
expr: expr ('*'|'/') expr |
      expr ('+'|'-') expr |
      INT |
      expr ')'
;
INT : '0'..'9'+ ;
NEWLINE: '\n' ;