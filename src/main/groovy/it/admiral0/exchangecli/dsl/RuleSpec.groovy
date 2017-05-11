package it.admiral0.exchangecli.dsl

import microsoft.exchange.webservices.data.property.complex.Rule

/**
 * Created by admiral0 on 4/29/17.
 */
class RuleSpec {
    Rule ruleObject;
    RuleSpec() {
        enabled()
        priority(1)
    }
    void disabled() { ruleObject.setIsEnabled(false) }
    void enabled() { ruleObject.setIsEnabled(true) }
    void priority(int priority) { ruleObject.setPriority(priority) }
    void name(String name) { ruleObject.setDisplayName(name) }
    private void predicate(@DelegatesTo(PredicateSpec) Closure cl, Closure container){
        def spec = new PredicateSpec(ruleObject, container)
        def code = cl.rehydrate(spec, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
    }
    void condition(@DelegatesTo(PredicateSpec) Closure cl){
        predicate(cl) {
            rule.getConditions()
        }
    }
    void exception(@DelegatesTo(PredicateSpec) Closure cl){
        predicate(cl) {
            rule.getExceptions()
        }
    }
    void action(Closure cl){
        def spec = new ActionSpec(ruleObject)
        def code = cl.rehydrate(spec, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
    }
}
