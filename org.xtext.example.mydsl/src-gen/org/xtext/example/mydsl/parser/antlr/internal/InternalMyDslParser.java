package org.xtext.example.mydsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'generate'", "'['", "']'", "'::='", "'|'", "'..'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;
     	
        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_gram_0_0= ruleGrammar ) ) ( (lv_gen_1_0= ruleGenerate ) ) ( (lv_rules_2_0= ruleRule ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_gram_0_0 = null;

        EObject lv_gen_1_0 = null;

        EObject lv_rules_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:79:28: ( ( ( (lv_gram_0_0= ruleGrammar ) ) ( (lv_gen_1_0= ruleGenerate ) ) ( (lv_rules_2_0= ruleRule ) )+ ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:1: ( ( (lv_gram_0_0= ruleGrammar ) ) ( (lv_gen_1_0= ruleGenerate ) ) ( (lv_rules_2_0= ruleRule ) )+ )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:1: ( ( (lv_gram_0_0= ruleGrammar ) ) ( (lv_gen_1_0= ruleGenerate ) ) ( (lv_rules_2_0= ruleRule ) )+ )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:2: ( (lv_gram_0_0= ruleGrammar ) ) ( (lv_gen_1_0= ruleGenerate ) ) ( (lv_rules_2_0= ruleRule ) )+
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:2: ( (lv_gram_0_0= ruleGrammar ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:81:1: (lv_gram_0_0= ruleGrammar )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:81:1: (lv_gram_0_0= ruleGrammar )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:82:3: lv_gram_0_0= ruleGrammar
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getGramGrammarParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleGrammar_in_ruleModel131);
            lv_gram_0_0=ruleGrammar();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"gram",
                    		lv_gram_0_0, 
                    		"Grammar");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:98:2: ( (lv_gen_1_0= ruleGenerate ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:99:1: (lv_gen_1_0= ruleGenerate )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:99:1: (lv_gen_1_0= ruleGenerate )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:100:3: lv_gen_1_0= ruleGenerate
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getGenGenerateParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleGenerate_in_ruleModel152);
            lv_gen_1_0=ruleGenerate();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"gen",
                    		lv_gen_1_0, 
                    		"Generate");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:116:2: ( (lv_rules_2_0= ruleRule ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:117:1: (lv_rules_2_0= ruleRule )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:117:1: (lv_rules_2_0= ruleRule )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:118:3: lv_rules_2_0= ruleRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getRulesRuleParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRule_in_ruleModel173);
            	    lv_rules_2_0=ruleRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_2_0, 
            	            		"Rule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleGrammar"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:142:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:143:2: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:144:2: iv_ruleGrammar= ruleGrammar EOF
            {
             newCompositeNode(grammarAccess.getGrammarRule()); 
            pushFollow(FOLLOW_ruleGrammar_in_entryRuleGrammar210);
            iv_ruleGrammar=ruleGrammar();

            state._fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammar220); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGrammar"


    // $ANTLR start "ruleGrammar"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:151:1: ruleGrammar returns [EObject current=null] : (otherlv_0= 'grammar' ( (lv_gname_1_0= RULE_ID ) ) ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_gname_1_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:154:28: ( (otherlv_0= 'grammar' ( (lv_gname_1_0= RULE_ID ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:155:1: (otherlv_0= 'grammar' ( (lv_gname_1_0= RULE_ID ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:155:1: (otherlv_0= 'grammar' ( (lv_gname_1_0= RULE_ID ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:155:3: otherlv_0= 'grammar' ( (lv_gname_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleGrammar257); 

                	newLeafNode(otherlv_0, grammarAccess.getGrammarAccess().getGrammarKeyword_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:159:1: ( (lv_gname_1_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:160:1: (lv_gname_1_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:160:1: (lv_gname_1_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:161:3: lv_gname_1_0= RULE_ID
            {
            lv_gname_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar274); 

            			newLeafNode(lv_gname_1_0, grammarAccess.getGrammarAccess().getGnameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGrammarRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"gname",
                    		lv_gname_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "entryRuleGenerate"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:185:1: entryRuleGenerate returns [EObject current=null] : iv_ruleGenerate= ruleGenerate EOF ;
    public final EObject entryRuleGenerate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerate = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:186:2: (iv_ruleGenerate= ruleGenerate EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:187:2: iv_ruleGenerate= ruleGenerate EOF
            {
             newCompositeNode(grammarAccess.getGenerateRule()); 
            pushFollow(FOLLOW_ruleGenerate_in_entryRuleGenerate315);
            iv_ruleGenerate=ruleGenerate();

            state._fsp--;

             current =iv_ruleGenerate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGenerate325); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenerate"


    // $ANTLR start "ruleGenerate"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:194:1: ruleGenerate returns [EObject current=null] : (otherlv_0= 'generate' ( (lv_genetool_1_0= RULE_ID ) ) ) ;
    public final EObject ruleGenerate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_genetool_1_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:197:28: ( (otherlv_0= 'generate' ( (lv_genetool_1_0= RULE_ID ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:198:1: (otherlv_0= 'generate' ( (lv_genetool_1_0= RULE_ID ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:198:1: (otherlv_0= 'generate' ( (lv_genetool_1_0= RULE_ID ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:198:3: otherlv_0= 'generate' ( (lv_genetool_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleGenerate362); 

                	newLeafNode(otherlv_0, grammarAccess.getGenerateAccess().getGenerateKeyword_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:202:1: ( (lv_genetool_1_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:203:1: (lv_genetool_1_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:203:1: (lv_genetool_1_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:204:3: lv_genetool_1_0= RULE_ID
            {
            lv_genetool_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGenerate379); 

            			newLeafNode(lv_genetool_1_0, grammarAccess.getGenerateAccess().getGenetoolIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGenerateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"genetool",
                    		lv_genetool_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenerate"


    // $ANTLR start "entryRuleRule"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:228:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:229:2: (iv_ruleRule= ruleRule EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:230:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_ruleRule_in_entryRuleRule420);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRule430); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:237:1: ruleRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_count_2_0= RULE_ID ) ) otherlv_3= ']' )? otherlv_4= '::=' ( (lv_expression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_count_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:240:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_count_2_0= RULE_ID ) ) otherlv_3= ']' )? otherlv_4= '::=' ( (lv_expression_5_0= ruleExpression ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:241:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_count_2_0= RULE_ID ) ) otherlv_3= ']' )? otherlv_4= '::=' ( (lv_expression_5_0= ruleExpression ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:241:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_count_2_0= RULE_ID ) ) otherlv_3= ']' )? otherlv_4= '::=' ( (lv_expression_5_0= ruleExpression ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:241:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_count_2_0= RULE_ID ) ) otherlv_3= ']' )? otherlv_4= '::=' ( (lv_expression_5_0= ruleExpression ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:241:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:242:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:242:1: (lv_name_0_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:243:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRule472); 

            			newLeafNode(lv_name_0_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:259:2: (otherlv_1= '[' ( (lv_count_2_0= RULE_ID ) ) otherlv_3= ']' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:259:4: otherlv_1= '[' ( (lv_count_2_0= RULE_ID ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleRule490); 

                        	newLeafNode(otherlv_1, grammarAccess.getRuleAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:263:1: ( (lv_count_2_0= RULE_ID ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:264:1: (lv_count_2_0= RULE_ID )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:264:1: (lv_count_2_0= RULE_ID )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:265:3: lv_count_2_0= RULE_ID
                    {
                    lv_count_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRule507); 

                    			newLeafNode(lv_count_2_0, grammarAccess.getRuleAccess().getCountIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"count",
                            		lv_count_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleRule524); 

                        	newLeafNode(otherlv_3, grammarAccess.getRuleAccess().getRightSquareBracketKeyword_1_2());
                        

                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleRule538); 

                	newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getColonColonEqualsSignKeyword_2());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:289:1: ( (lv_expression_5_0= ruleExpression ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:290:1: (lv_expression_5_0= ruleExpression )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:290:1: (lv_expression_5_0= ruleExpression )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:291:3: lv_expression_5_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getRuleAccess().getExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleRule559);
            lv_expression_5_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuleRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_5_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleExpression"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:315:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:316:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:317:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression595);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression605); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:324:1: ruleExpression returns [EObject current=null] : ( ( (lv_elements_0_0= ruleElement ) ) (otherlv_1= '|' ( (lv_elements_2_0= ruleElement ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_elements_0_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:327:28: ( ( ( (lv_elements_0_0= ruleElement ) ) (otherlv_1= '|' ( (lv_elements_2_0= ruleElement ) ) )* ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:328:1: ( ( (lv_elements_0_0= ruleElement ) ) (otherlv_1= '|' ( (lv_elements_2_0= ruleElement ) ) )* )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:328:1: ( ( (lv_elements_0_0= ruleElement ) ) (otherlv_1= '|' ( (lv_elements_2_0= ruleElement ) ) )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:328:2: ( (lv_elements_0_0= ruleElement ) ) (otherlv_1= '|' ( (lv_elements_2_0= ruleElement ) ) )*
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:328:2: ( (lv_elements_0_0= ruleElement ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:329:1: (lv_elements_0_0= ruleElement )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:329:1: (lv_elements_0_0= ruleElement )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:330:3: lv_elements_0_0= ruleElement
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getElementsElementParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleElement_in_ruleExpression651);
            lv_elements_0_0=ruleElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"elements",
                    		lv_elements_0_0, 
                    		"Element");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:346:2: (otherlv_1= '|' ( (lv_elements_2_0= ruleElement ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:346:4: otherlv_1= '|' ( (lv_elements_2_0= ruleElement ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleExpression664); 

            	        	newLeafNode(otherlv_1, grammarAccess.getExpressionAccess().getVerticalLineKeyword_1_0());
            	        
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:350:1: ( (lv_elements_2_0= ruleElement ) )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:351:1: (lv_elements_2_0= ruleElement )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:351:1: (lv_elements_2_0= ruleElement )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:352:3: lv_elements_2_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getElementsElementParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleExpression685);
            	    lv_elements_2_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_2_0, 
            	            		"Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleElement"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:376:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:377:2: (iv_ruleElement= ruleElement EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:378:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement723);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement733); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:385:1: ruleElement returns [EObject current=null] : ( (lv_terms_0_0= ruleTerm ) )+ ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject lv_terms_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:388:28: ( ( (lv_terms_0_0= ruleTerm ) )+ )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:389:1: ( (lv_terms_0_0= ruleTerm ) )+
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:389:1: ( (lv_terms_0_0= ruleTerm ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==EOF||(LA4_2>=RULE_ID && LA4_2<=RULE_STRING)||LA4_2==16) ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0==RULE_STRING) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:390:1: (lv_terms_0_0= ruleTerm )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:390:1: (lv_terms_0_0= ruleTerm )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:391:3: lv_terms_0_0= ruleTerm
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElementAccess().getTermsTermParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerm_in_ruleElement778);
            	    lv_terms_0_0=ruleTerm();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getElementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"terms",
            	            		lv_terms_0_0, 
            	            		"Term");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleTerm"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:415:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:416:2: (iv_ruleTerm= ruleTerm EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:417:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm814);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm824); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:424:1: ruleTerm returns [EObject current=null] : ( ( (lv_kConstr_0_0= ruleKeyConstr ) ) | ( (lv_rCall_1_0= ruleRuleCall ) ) ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_kConstr_0_0 = null;

        EObject lv_rCall_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:427:28: ( ( ( (lv_kConstr_0_0= ruleKeyConstr ) ) | ( (lv_rCall_1_0= ruleRuleCall ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:428:1: ( ( (lv_kConstr_0_0= ruleKeyConstr ) ) | ( (lv_rCall_1_0= ruleRuleCall ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:428:1: ( ( (lv_kConstr_0_0= ruleKeyConstr ) ) | ( (lv_rCall_1_0= ruleRuleCall ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:428:2: ( (lv_kConstr_0_0= ruleKeyConstr ) )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:428:2: ( (lv_kConstr_0_0= ruleKeyConstr ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:429:1: (lv_kConstr_0_0= ruleKeyConstr )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:429:1: (lv_kConstr_0_0= ruleKeyConstr )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:430:3: lv_kConstr_0_0= ruleKeyConstr
                    {
                     
                    	        newCompositeNode(grammarAccess.getTermAccess().getKConstrKeyConstrParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleKeyConstr_in_ruleTerm870);
                    lv_kConstr_0_0=ruleKeyConstr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTermRule());
                    	        }
                           		add(
                           			current, 
                           			"kConstr",
                            		lv_kConstr_0_0, 
                            		"KeyConstr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:447:6: ( (lv_rCall_1_0= ruleRuleCall ) )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:447:6: ( (lv_rCall_1_0= ruleRuleCall ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:448:1: (lv_rCall_1_0= ruleRuleCall )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:448:1: (lv_rCall_1_0= ruleRuleCall )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:449:3: lv_rCall_1_0= ruleRuleCall
                    {
                     
                    	        newCompositeNode(grammarAccess.getTermAccess().getRCallRuleCallParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleTerm897);
                    lv_rCall_1_0=ruleRuleCall();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTermRule());
                    	        }
                           		add(
                           			current, 
                           			"rCall",
                            		lv_rCall_1_0, 
                            		"RuleCall");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleKeyConstr"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:473:1: entryRuleKeyConstr returns [EObject current=null] : iv_ruleKeyConstr= ruleKeyConstr EOF ;
    public final EObject entryRuleKeyConstr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyConstr = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:474:2: (iv_ruleKeyConstr= ruleKeyConstr EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:475:2: iv_ruleKeyConstr= ruleKeyConstr EOF
            {
             newCompositeNode(grammarAccess.getKeyConstrRule()); 
            pushFollow(FOLLOW_ruleKeyConstr_in_entryRuleKeyConstr933);
            iv_ruleKeyConstr=ruleKeyConstr();

            state._fsp--;

             current =iv_ruleKeyConstr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyConstr943); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyConstr"


    // $ANTLR start "ruleKeyConstr"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:482:1: ruleKeyConstr returns [EObject current=null] : ( ( (lv_SChar_0_0= RULE_STRING ) ) (otherlv_1= '..' ( (lv_EChar_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyConstr() throws RecognitionException {
        EObject current = null;

        Token lv_SChar_0_0=null;
        Token otherlv_1=null;
        Token lv_EChar_2_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:485:28: ( ( ( (lv_SChar_0_0= RULE_STRING ) ) (otherlv_1= '..' ( (lv_EChar_2_0= RULE_STRING ) ) )? ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:486:1: ( ( (lv_SChar_0_0= RULE_STRING ) ) (otherlv_1= '..' ( (lv_EChar_2_0= RULE_STRING ) ) )? )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:486:1: ( ( (lv_SChar_0_0= RULE_STRING ) ) (otherlv_1= '..' ( (lv_EChar_2_0= RULE_STRING ) ) )? )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:486:2: ( (lv_SChar_0_0= RULE_STRING ) ) (otherlv_1= '..' ( (lv_EChar_2_0= RULE_STRING ) ) )?
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:486:2: ( (lv_SChar_0_0= RULE_STRING ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:487:1: (lv_SChar_0_0= RULE_STRING )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:487:1: (lv_SChar_0_0= RULE_STRING )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:488:3: lv_SChar_0_0= RULE_STRING
            {
            lv_SChar_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyConstr985); 

            			newLeafNode(lv_SChar_0_0, grammarAccess.getKeyConstrAccess().getSCharSTRINGTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeyConstrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"SChar",
                    		lv_SChar_0_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:504:2: (otherlv_1= '..' ( (lv_EChar_2_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:504:4: otherlv_1= '..' ( (lv_EChar_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleKeyConstr1003); 

                        	newLeafNode(otherlv_1, grammarAccess.getKeyConstrAccess().getFullStopFullStopKeyword_1_0());
                        
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:508:1: ( (lv_EChar_2_0= RULE_STRING ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:509:1: (lv_EChar_2_0= RULE_STRING )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:509:1: (lv_EChar_2_0= RULE_STRING )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:510:3: lv_EChar_2_0= RULE_STRING
                    {
                    lv_EChar_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyConstr1020); 

                    			newLeafNode(lv_EChar_2_0, grammarAccess.getKeyConstrAccess().getECharSTRINGTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeyConstrRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"EChar",
                            		lv_EChar_2_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyConstr"


    // $ANTLR start "entryRuleRuleCall"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:534:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:535:2: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:536:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             newCompositeNode(grammarAccess.getRuleCallRule()); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall1063);
            iv_ruleRuleCall=ruleRuleCall();

            state._fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall1073); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleCall"


    // $ANTLR start "ruleRuleCall"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:543:1: ruleRuleCall returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:546:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:547:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:547:1: ( (otherlv_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:548:1: (otherlv_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:548:1: (otherlv_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:549:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall1117); 

            		newLeafNode(otherlv_0, grammarAccess.getRuleCallAccess().getRefRuleCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleCall"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGrammar_in_ruleModel131 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleGenerate_in_ruleModel152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRule_in_ruleModel173 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammar257 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGenerate_in_entryRuleGenerate315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGenerate325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleGenerate362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGenerate379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRule_in_entryRuleRule420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRule430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRule472 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_13_in_ruleRule490 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRule507 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleRule524 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleRule538 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleRule559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression595 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleExpression651 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleExpression664 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleElement_in_ruleExpression685 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleElement778 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyConstr_in_ruleTerm870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerm897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyConstr_in_entryRuleKeyConstr933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyConstr943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyConstr985 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleKeyConstr1003 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyConstr1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall1063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall1117 = new BitSet(new long[]{0x0000000000000002L});

}