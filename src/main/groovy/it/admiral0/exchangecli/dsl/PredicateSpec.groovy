package it.admiral0.exchangecli.dsl

import microsoft.exchange.webservices.data.property.complex.Rule
import microsoft.exchange.webservices.data.property.complex.RulePredicates

/**
 * Created by admiral0 on 4/29/17.
 */
class PredicateSpec {
    private Rule rule
    private RulePredicates target
    PredicateSpec(Rule rule, Closure selector){
        this.rule = rule
        this.target = selector()
    }
    void matchCategory(String... categories) {
        categories.each {
            target.getCategories().add(it)
        }
    }
    void bodyContains(String... body) {
        body.each {
            target.getContainsBodyStrings().add(it)
        }
    }
    void headerContains(String... header) {
        header.each {
            target.getContainsHeaderStrings().add(it)
        }
    }
    void senderContains(String... sender) {
        sender.each {
            target.getContainsSenderStrings().add(it)
        }
    }
    void recipientContains(String... rcp) {
        rcp.each {
            target.getContainsRecipientStrings().add(it)
        }
    }
    void subjectOrBodyContains(String... strings) {
        strings.each {
            target.getContainsSubjectOrBodyStrings().add(it)
        }
    }
    void subjectContains(String... subj) {
        subj.each {
            target.getContainsSubjectStrings().add(it)
        }
    }
    void fromAddresses(String... emails) {
        emails.each {
            target.getFromAddresses().add(it)
        }
    }
    void withAttachments(boolean value = true) { target.setHasAttachments(value) }
    void isAnApprovalRequest(boolean value = true) { target.setIsApprovalRequest(value) }
    void isAutoForward(boolean value = true) { target.setIsAutomaticForward(value) }
    void isAutoReply(boolean value = true) { target.setIsAutomaticReply(value) }
    void isEncrypted(boolean value = true) { target.setIsEncrypted(value) }
    void isMeetingRequest(boolean value = true) { target.setIsMeetingRequest(value) }
    void isNonDeliveryReport(boolean value = true) { target.setIsNonDeliveryReport(value) }
    void isPermissionControlled(boolean value = true) { target.setIsPermissionControlled(value) }
    void isSigned(boolean value = true) { target.setIsSigned(value) }
    void isVoicemail(boolean value = true) { target.setIsVoicemail(value) }
    void isReadReceipt(boolean value = true) { target.setIsReadReceipt(value) }
    void fromConnectedAccounts(String... email){
        email.each {
            target.getFromConnectedAccounts().add(it)
        }
    }
    void itemClasses(String... classes) { classes.each {
        target.getItemClasses().add(it)
    }}
    //WTF
    void notSentToMe(boolean value = true) { target.setNotSentToMe(value) }
    void sentToMe(boolean value = true) { target.setSentToMe(value) }

    void ccdToMe(boolean value = true) { target.setSentCcMe(value) }
    void sentOnlyToMe(boolean value = true) { target.setSentOnlyToMe(value) }
    void sentToAddresses(String... emails) { emails.each {
        target.getSentToAddresses().add(it)
    }}
    void sentOrCCToMe(boolean value = true) { target.setSentToOrCcMe(value) }

    // Not implemented
    //void flagged for action
    //void date(Closure cl) {}
    //void size(Closure cl){}


}
