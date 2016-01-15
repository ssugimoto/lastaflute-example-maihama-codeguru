/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.app.web.signin;

import javax.annotation.Resource;

import org.docksidestage.app.web.RootAction;
import org.docksidestage.app.web.base.DocksideBaseAction;
import org.docksidestage.app.web.base.login.DocksideLoginAssist;
import org.docksidestage.mylasta.action.DocksideMessages;
import org.lastaflute.web.Execute;
import org.lastaflute.web.response.HtmlResponse;

/**
 * @author jflute
 */
public class SigninAction extends DocksideBaseAction {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    private DocksideLoginAssist docksideLoginAssist;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute
    public HtmlResponse index() {
        if (getUserBean().isPresent()) {
            return redirect(RootAction.class);
        }
        return asHtml(path_Signin_SigninHtml);
    }

    @Execute
    public HtmlResponse signin(SigninForm form) {
        validate(form, messages -> moreValidate(form, messages), () -> {
            form.clearSecurityInfo();
            return asHtml(path_Signin_SigninHtml);
        });
        return docksideLoginAssist.loginRedirect(form.account, form.password, op -> op.rememberMe(form.rememberMe), () -> {
            return redirect(RootAction.class);
        });
    }

    private void moreValidate(SigninForm form, DocksideMessages messages) {
        if (isNotEmpty(form.account) && isNotEmpty(form.password)) {
            if (!docksideLoginAssist.checkUserLoginable(form.account, form.password)) {
                messages.addErrorsLoginFailure("account");
            }
        }
    }
}