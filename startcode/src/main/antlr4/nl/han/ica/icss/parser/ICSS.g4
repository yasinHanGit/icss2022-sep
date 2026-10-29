grammar ICSS;


//--- LEXER: ---


// IF support:
IF: 'if';
ELSE: 'else';
BOX_BRACKET_OPEN: '[';
BOX_BRACKET_CLOSE: ']';


//literal
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

SMALLER: '<';
BIGGER: '>';
EQUAL: '==';
NOTEQUAL: '!=';



//--- PARSER: ---




propertyName: 'background-color' | 'color' | 'width' | 'height';

variableReference: CAPITAL_IDENT;
bool: TRUE | FALSE;

literal: PIXELSIZE | PERCENTAGE | COLOR | bool | SCALAR;
variableAssignment: variableReference ASSIGNMENT_OPERATOR (expression | boolOperation) SEMICOLON;

selector: LOWER_IDENT | ID_IDENT | CLASS_IDENT;

declaration: propertyName COLON expression SEMICOLON;

expression:
           operand                                  #op
           |    expression MUL  expression          #mulOperation
           |    expression PLUS expression          #addOperation
           |    expression MIN  expression          #subtractOperation;

styleRule: selector OPEN_BRACE (declaration | ifClause | variableAssignment)+ CLOSE_BRACE;

operand: literal | variableReference;
statement: OPEN_BRACE (declaration | ifClause | variableAssignment)+ CLOSE_BRACE;
ifClause: IF BOX_BRACKET_OPEN (variableReference | bool | boolOperation) BOX_BRACKET_CLOSE statement elseClause?;
elseClause: ELSE statement;


boolOperation:
                (literal | variableReference) SMALLER (literal | variableReference)     #smallerBool
                | (literal | variableReference) BIGGER (literal | variableReference)    #biggerBool
                | (literal | variableReference) EQUAL (literal | variableReference)     #equalBool
                | (literal | variableReference) NOTEQUAL (literal | variableReference)  #notEqualBool;



stylesheet: variableAssignment* styleRule* ;
