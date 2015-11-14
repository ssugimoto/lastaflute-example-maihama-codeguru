/*
 * Copyright 2014-2015 the original author or authors.
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
package org.docksidestage.mylasta.action;

import org.lastaflute.web.response.next.HtmlNext;

/**
 * The path definition of HTML.
 * @author FreeGen
 */
public interface DocksideHtmlPath {

    /** The path of the HTML: /error/error_message.html */
    HtmlNext path_Error_ErrorMessageHtml = new HtmlNext("/error/error_message.html");

    /** The path of the HTML: /error/error_message.jsp */
    HtmlNext path_Error_ErrorMessageJsp = new HtmlNext("/error/error_message.jsp");

    /** The path of the HTML: /member/member_add.html */
    HtmlNext path_Member_MemberAddHtml = new HtmlNext("/member/member_add.html");

    /** The path of the HTML: /member/member_add.jsp */
    HtmlNext path_Member_MemberAddJsp = new HtmlNext("/member/member_add.jsp");

    /** The path of the HTML: /member/member_edit.jsp */
    HtmlNext path_Member_MemberEditJsp = new HtmlNext("/member/member_edit.jsp");

    /** The path of the HTML: /member/member_list.html */
    HtmlNext path_Member_MemberListHtml = new HtmlNext("/member/member_list.html");

    /** The path of the HTML: /member/member_list.jsp */
    HtmlNext path_Member_MemberListJsp = new HtmlNext("/member/member_list.jsp");

    /** The path of the HTML: /member/purchase/member_purchase_list.jsp */
    HtmlNext path_MemberPurchase_MemberPurchaseListJsp = new HtmlNext("/member/purchase/member_purchase_list.jsp");

    /** The path of the HTML: /mypage/mypage.html */
    HtmlNext path_Mypage_MypageHtml = new HtmlNext("/mypage/mypage.html");

    /** The path of the HTML: /mypage/mypage.jsp */
    HtmlNext path_Mypage_MypageJsp = new HtmlNext("/mypage/mypage.jsp");

    /** The path of the HTML: /product/product_detail.html */
    HtmlNext path_Product_ProductDetailHtml = new HtmlNext("/product/product_detail.html");

    /** The path of the HTML: /product/product_detail.jsp */
    HtmlNext path_Product_ProductDetailJsp = new HtmlNext("/product/product_detail.jsp");

    /** The path of the HTML: /product/product_list.html */
    HtmlNext path_Product_ProductListHtml = new HtmlNext("/product/product_list.html");

    /** The path of the HTML: /product/product_list.jsp */
    HtmlNext path_Product_ProductListJsp = new HtmlNext("/product/product_list.jsp");

    /** The path of the HTML: /profile/profile.html */
    HtmlNext path_Profile_ProfileHtml = new HtmlNext("/profile/profile.html");

    /** The path of the HTML: /profile/profile.jsp */
    HtmlNext path_Profile_ProfileJsp = new HtmlNext("/profile/profile.jsp");

    /** The path of the HTML: /purchase/purchase_list.jsp */
    HtmlNext path_Purchase_PurchaseListJsp = new HtmlNext("/purchase/purchase_list.jsp");

    /** The path of the HTML: /signin/signin.html */
    HtmlNext path_Signin_SigninHtml = new HtmlNext("/signin/signin.html");

    /** The path of the HTML: /signin/signin.jsp */
    HtmlNext path_Signin_SigninJsp = new HtmlNext("/signin/signin.jsp");

    /** The path of the HTML: /signin/signin_reminder.html */
    HtmlNext path_Signin_SigninReminderHtml = new HtmlNext("/signin/signin_reminder.html");

    /** The path of the HTML: /signup/signup.html */
    HtmlNext path_Signup_SignupHtml = new HtmlNext("/signup/signup.html");

    /** The path of the HTML: /startup/startup.html */
    HtmlNext path_Startup_StartupHtml = new HtmlNext("/startup/startup.html");

    /** The path of the HTML: /startup/startup.jsp */
    HtmlNext path_Startup_StartupJsp = new HtmlNext("/startup/startup.jsp");

    /** The path of the HTML: /withdrawal/withdrawal.jsp */
    HtmlNext path_Withdrawal_WithdrawalJsp = new HtmlNext("/withdrawal/withdrawal.jsp");

    /** The path of the HTML: /withdrawal/withdrawal_confirm.jsp */
    HtmlNext path_Withdrawal_WithdrawalConfirmJsp = new HtmlNext("/withdrawal/withdrawal_confirm.jsp");
}
