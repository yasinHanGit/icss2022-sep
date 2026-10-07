grammar ICSS;

//--- LEXER: ---

// IF support:
IF: 'if';
ELSE: 'else';
BOX_BRACKET_OPEN: '[';
BOX_BRACKET_CLOSE: ']';


//Literals
TRUE: 'TRUE';
FALSE: 'FALSE';
PIXELSIZE: [0-9]+ 'px';
PERCENTAGE: [0-9]+ '%';
SCALAR: [0-9]+;


//Color value takes precedence over id idents
COLOR: '#' [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f];

//Specific identifiers for id's and css classes
ID_IDENT: '#' [a-z0-9\-]+;
CLASS_IDENT: '.' [a-z0-9\-]+;

//General identifiers
LOWER_IDENT: [a-z] [a-z0-9\-]*;
CAPITAL_IDENT: [A-Z] [A-Za-z0-9_]*;

//All whitespace is skipped
WS: [ \t\r\n]+ -> skip;

//
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
SEMICOLON: ';';
COLON: ':';
PLUS: '+';
MIN: '-';
MUL: '*';
ASSIGNMENT_OPERATOR: ':=';





//--- PARSER: ---



variable_id: CAPITAL_IDENT;
oparator: MUL | PLUS | MIN;
bool: TRUE | FALSE;

literals: PIXELSIZE | PERCENTAGE | COLOR | bool | SCALAR;
variable: variable_id ASSIGNMENT_OPERATOR literals SEMICOLON;


selector: LOWER_IDENT | ID_IDENT | CLASS_IDENT;

declaration: LOWER_IDENT COLON (variable_id | literals | sum) SEMICOLON;

sum: (variable_id | literals) (oparator sum)?;

rule: selector OPEN_BRACE (declaration | if_statement)+ CLOSE_BRACE;


statement: OPEN_BRACE (declaration | if_statement)+ CLOSE_BRACE;
if_statement: IF BOX_BRACKET_OPEN variable_id BOX_BRACKET_CLOSE statement | else_statement;
else_statement: ELSE statement;

stylesheet: variable* rule* ;

