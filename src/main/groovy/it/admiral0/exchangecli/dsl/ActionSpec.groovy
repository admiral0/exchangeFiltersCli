package it.admiral0.exchangecli.dsl

import microsoft.exchange.webservices.data.core.enumeration.property.Importance
import microsoft.exchange.webservices.data.misc.MobilePhone
import microsoft.exchange.webservices.data.property.complex.Rule
import microsoft.exchange.webservices.data.property.complex.RuleActions

/**
 * Created by admiral0 on 4/29/17.
 */
class ActionSpec {
    private Rule rule
    private RuleActions actions
    ActionSpec(Rule rule){
        this.rule = rule
        actions = rule.getActions()
    }
    void assignCategories(String... categories){
        categories.each {
            actions.getAssignCategories().add(it)
        }
    }
    void copyToFolder(String folder){
        //FIXME
    }

    void delete(){ actions.setDelete(true) }
    void forwardAsAttachmentTo(String... emails) {
        emails.each {
            actions.getForwardAsAttachmentToRecipients().add(it)
        }
    }
    void forwardTo(String... emails) {
        emails.each {
            actions.getForwardToRecipients().add(it)
        }
    }
    void importance(String importance){
        if (importance.equalsIgnoreCase('high') ){
            actions.setMarkImportance(Importance.High)
        }
        if (importance.equalsIgnoreCase('low')) {
            actions.setMarkImportance(Importance.Low)
        }
        actions.setMarkImportance(Importance.Normal)
    }

    void markAsRead() {
        actions.setMarkAsRead(true)
    }

    void moveToFolder(String folder) {

    }
    void deletePermanently() { actions.setPermanentDelete(true) }
    void nuke() { deletePermanently()  }
    void killItWithFire(){ deletePermanently() }
    void redirect(String... emails){ emails.each {
        actions.getRedirectToRecipients().add(it)
    } }
    void smsNotify(String name, String... number){ number.each {
        actions.getSendSMSAlertToRecipients().add(new MobilePhone(name, it))
    }}
    void stopProcessing(){
        actions.setStopProcessingRules(true)
    }
    void sayonara() { stopProcessing() }
    void kthxby() { stopProcessing() }

    // Not implemented, but will do soon
    // void serverReplyWith(Stuff)

}
