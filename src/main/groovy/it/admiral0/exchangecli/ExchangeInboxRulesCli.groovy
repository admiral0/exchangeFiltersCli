package it.admiral0.exchangecli

/**
 * Created by admiral0 on 4/29/17.
 */
class ExchangeInboxRulesCli {
    public static void main(String[] args){
        def cli = new CliBuilder(usage: 'Sync rules to Exchange Server')



        def parsed = cli.parse(args)
        print(parsed)
    }
}
