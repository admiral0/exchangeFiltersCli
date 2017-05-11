package it.admiral0.exchangecli.dsl

import microsoft.exchange.webservices.data.property.complex.Rule

/**
 * Created by admiral0 on 4/29/17.
 */
class RulesSpec {
    ArrayList<Rule> ruleContainer;
    RulesSpec()
    void rule(@DelegatesTo(RuleSpec) Closure cl){
        def spec = new RuleSpec()
        def code = cl.rehydrate(spec, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        ruleContainer.add(spec.ruleObject)
    }
}
