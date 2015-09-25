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
package org.docksidestage.dbflute.allcommon;

import java.util.*;

import org.dbflute.jdbc.Classification;
import org.dbflute.jdbc.ClassificationCodeType;
import org.dbflute.jdbc.ClassificationMeta;
import org.dbflute.jdbc.ClassificationUndefinedHandlingType;

/**
 * The definition of classification.
 * @author DBFlute(AutoGenerator)
 */
public interface CDef extends Classification {

    /** The empty array for no sisters. */
    String[] EMPTY_SISTERS = new String[]{};

    /** The empty map for no sub-items. */
    @SuppressWarnings("unchecked")
    Map<String, Object> EMPTY_SUB_ITEM_MAP = Collections.EMPTY_MAP;

    /**
     * フラグを示す
     */
    public enum Flg implements CDef {
        /** はい: 有効を示す */
        True("1", "はい", new String[] {"true"})
        ,
        /** いいえ: 無効を示す */
        False("0", "いいえ", new String[] {"false"})
        ;
        private static final Map<String, Flg> _codeValueMap = new HashMap<String, Flg>();
        static {
            for (Flg value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Flg(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        @Override
        public String code() { return _code; } @Override
        public String alias() { return _alias; }
        @Override
        public Set<String> sisterSet() { return _sisterSet; }
        @Override
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        @Override
        public ClassificationMeta meta() { return CDef.DefMeta.Flg; }

        @Override
        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Flg codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Flg) { return (Flg)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Flg nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<Flg> listAll() {
            return new ArrayList<Flg>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<Flg> groupOf(String groupName) {
            return new ArrayList<Flg>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 入会から退会までの会員のステータスを示す
     */
    public enum MemberStatus implements CDef {
        /** Formalized: as formal member, allowed to use all service */
        Formalized("FML", "Formalized", EMPTY_SISTERS)
        ,
        /** Withdrawal: withdrawal is fixed, not allowed to use service */
        Withdrawal("WDL", "Withdrawal", EMPTY_SISTERS)
        ,
        /** Provisional: first status after entry, allowed to use only part of service */
        Provisional("PRV", "Provisional", EMPTY_SISTERS)
        ;
        private static final Map<String, MemberStatus> _codeValueMap = new HashMap<String, MemberStatus>();
        static {
            for (MemberStatus value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private MemberStatus(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        @Override
        public String code() { return _code; } @Override
        public String alias() { return _alias; }
        @Override
        public Set<String> sisterSet() { return _sisterSet; }
        @Override
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        @Override
        public ClassificationMeta meta() { return CDef.DefMeta.MemberStatus; }

        /**
         * Is the classification in the group? <br>
         * Members that can use the service, can sign in <br>
         * The group elements:[Formalized, Provisional]
         * @return The determination, true or false.
         */
        public boolean isServiceAvailable() {
            return Formalized.equals(this) || Provisional.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * Members are not formalized yet <br>
         * The group elements:[Provisional]
         * @return The determination, true or false.
         */
        public boolean isShortOfFormalized() {
            return Provisional.equals(this);
        }

        @Override
        public boolean inGroup(String groupName) {
            if ("serviceAvailable".equals(groupName)) { return isServiceAvailable(); }
            if ("shortOfFormalized".equals(groupName)) { return isShortOfFormalized(); }
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static MemberStatus codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof MemberStatus) { return (MemberStatus)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static MemberStatus nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<MemberStatus> listAll() {
            return new ArrayList<MemberStatus>(Arrays.asList(values()));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * Members that can use the service, can sign in <br>
         * The group elements:[Formalized, Provisional]
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<MemberStatus> listOfServiceAvailable() {
            return new ArrayList<MemberStatus>(Arrays.asList(Formalized, Provisional));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * Members are not formalized yet <br>
         * The group elements:[Provisional]
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<MemberStatus> listOfShortOfFormalized() {
            return new ArrayList<MemberStatus>(Arrays.asList(Provisional));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<MemberStatus> groupOf(String groupName) {
            if ("serviceAvailable".equals(groupName)) { return listOfServiceAvailable(); }
            if ("shortOfFormalized".equals(groupName)) { return listOfShortOfFormalized(); }
            return new ArrayList<MemberStatus>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 会員が受けられるサービスのランクを示す
     */
    public enum ServiceRank implements CDef {
        /** PLATINUM: platinum rank */
        Platinum("PLT", "PLATINUM", EMPTY_SISTERS)
        ,
        /** GOLD: gold rank */
        Gold("GLD", "GOLD", EMPTY_SISTERS)
        ,
        /** SILVER: silver rank */
        Silver("SIL", "SILVER", EMPTY_SISTERS)
        ,
        /** BRONZE: bronze rank */
        Bronze("BRZ", "BRONZE", EMPTY_SISTERS)
        ,
        /** PLASTIC: plastic rank */
        Plastic("PLS", "PLASTIC", EMPTY_SISTERS)
        ;
        private static final Map<String, ServiceRank> _codeValueMap = new HashMap<String, ServiceRank>();
        static {
            for (ServiceRank value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private ServiceRank(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        @Override
        public String code() { return _code; } @Override
        public String alias() { return _alias; }
        @Override
        public Set<String> sisterSet() { return _sisterSet; }
        @Override
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        @Override
        public ClassificationMeta meta() { return CDef.DefMeta.ServiceRank; }

        @Override
        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static ServiceRank codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof ServiceRank) { return (ServiceRank)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static ServiceRank nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<ServiceRank> listAll() {
            return new ArrayList<ServiceRank>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<ServiceRank> groupOf(String groupName) {
            return new ArrayList<ServiceRank>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 主に会員の住んでいる地域を示す
     */
    public enum Region implements CDef {
        /** AMERICA */
        America("1", "AMERICA", EMPTY_SISTERS)
        ,
        /** CANADA */
        Canada("2", "CANADA", EMPTY_SISTERS)
        ,
        /** CHINA */
        China("3", "CHINA", EMPTY_SISTERS)
        ,
        /** CHIBA */
        Chiba("4", "CHIBA", EMPTY_SISTERS)
        ;
        private static final Map<String, Region> _codeValueMap = new HashMap<String, Region>();
        static {
            for (Region value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Region(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        @Override
        public String code() { return _code; } @Override
        public String alias() { return _alias; }
        @Override
        public Set<String> sisterSet() { return _sisterSet; }
        @Override
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        @Override
        public ClassificationMeta meta() { return CDef.DefMeta.Region; }

        @Override
        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Region codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Region) { return (Region)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Region nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<Region> listAll() {
            return new ArrayList<Region>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<Region> groupOf(String groupName) {
            return new ArrayList<Region>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 会員の退会理由。なのでちょっとねがてぃぶ
     */
    public enum WithdrawalReason implements CDef {
        /** site is not kindness: site is not kindness */
        Sit("SIT", "site is not kindness", EMPTY_SISTERS)
        ,
        /** no attractive product: no attractive product */
        Prd("PRD", "no attractive product", EMPTY_SISTERS)
        ,
        /** because of furiten: because of furiten */
        Frt("FRT", "because of furiten", EMPTY_SISTERS)
        ,
        /** other reasons: other reasons */
        Oth("OTH", "other reasons", EMPTY_SISTERS)
        ;
        private static final Map<String, WithdrawalReason> _codeValueMap = new HashMap<String, WithdrawalReason>();
        static {
            for (WithdrawalReason value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private WithdrawalReason(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        @Override
        public String code() { return _code; } @Override
        public String alias() { return _alias; }
        @Override
        public Set<String> sisterSet() { return _sisterSet; }
        @Override
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        @Override
        public ClassificationMeta meta() { return CDef.DefMeta.WithdrawalReason; }

        @Override
        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static WithdrawalReason codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof WithdrawalReason) { return (WithdrawalReason)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static WithdrawalReason nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<WithdrawalReason> listAll() {
            return new ArrayList<WithdrawalReason>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<WithdrawalReason> groupOf(String groupName) {
            return new ArrayList<WithdrawalReason>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 商品のカテゴリ。階層構造である
     */
    public enum ProductCategory implements CDef {
        /** Music */
        Music("MSC", "Music", EMPTY_SISTERS)
        ,
        /** Food */
        Food("FOD", "Food", EMPTY_SISTERS)
        ,
        /** Herb: of Food */
        Herb("HEB", "Herb", EMPTY_SISTERS)
        ,
        /** MusicCD: of Music */
        MusicCD("MCD", "MusicCD", EMPTY_SISTERS)
        ,
        /** Instruments: of Music */
        Instruments("INS", "Instruments", EMPTY_SISTERS)
        ;
        private static final Map<String, ProductCategory> _codeValueMap = new HashMap<String, ProductCategory>();
        static {
            for (ProductCategory value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private ProductCategory(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        @Override
        public String code() { return _code; } @Override
        public String alias() { return _alias; }
        @Override
        public Set<String> sisterSet() { return _sisterSet; }
        @Override
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        @Override
        public ClassificationMeta meta() { return CDef.DefMeta.ProductCategory; }

        @Override
        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static ProductCategory codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof ProductCategory) { return (ProductCategory)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static ProductCategory nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<ProductCategory> listAll() {
            return new ArrayList<ProductCategory>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<ProductCategory> groupOf(String groupName) {
            return new ArrayList<ProductCategory>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 商品ステータス。あんまり面白みのないステータス
     */
    public enum ProductStatus implements CDef {
        /** OnSaleProduction */
        OnSaleProduction("ONS", "OnSaleProduction", EMPTY_SISTERS)
        ,
        /** ProductionStop */
        ProductionStop("PST", "ProductionStop", EMPTY_SISTERS)
        ,
        /** SaleStop */
        SaleStop("SST", "SaleStop", EMPTY_SISTERS)
        ;
        private static final Map<String, ProductStatus> _codeValueMap = new HashMap<String, ProductStatus>();
        static {
            for (ProductStatus value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private ProductStatus(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        @Override
        public String code() { return _code; } @Override
        public String alias() { return _alias; }
        @Override
        public Set<String> sisterSet() { return _sisterSet; }
        @Override
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        @Override
        public ClassificationMeta meta() { return CDef.DefMeta.ProductStatus; }

        @Override
        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static ProductStatus codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof ProductStatus) { return (ProductStatus)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static ProductStatus nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<ProductStatus> listAll() {
            return new ArrayList<ProductStatus>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<ProductStatus> groupOf(String groupName) {
            return new ArrayList<ProductStatus>(4);
        }

        @Override public String toString() { return code(); }
    }

    public enum DefMeta implements ClassificationMeta {
        /** フラグを示す */
        Flg
        ,
        /** 入会から退会までの会員のステータスを示す */
        MemberStatus
        ,
        /** 会員が受けられるサービスのランクを示す */
        ServiceRank
        ,
        /** 主に会員の住んでいる地域を示す */
        Region
        ,
        /** 会員の退会理由。なのでちょっとねがてぃぶ */
        WithdrawalReason
        ,
        /** 商品のカテゴリ。階層構造である */
        ProductCategory
        ,
        /** 商品ステータス。あんまり面白みのないステータス */
        ProductStatus
        ;
        @Override
        public String classificationName() {
            return name(); // same as definition name
        }

        @Override
        public Classification codeOf(Object code) {
            if ("Flg".equals(name())) { return CDef.Flg.codeOf(code); }
            if ("MemberStatus".equals(name())) { return CDef.MemberStatus.codeOf(code); }
            if ("ServiceRank".equals(name())) { return CDef.ServiceRank.codeOf(code); }
            if ("Region".equals(name())) { return CDef.Region.codeOf(code); }
            if ("WithdrawalReason".equals(name())) { return CDef.WithdrawalReason.codeOf(code); }
            if ("ProductCategory".equals(name())) { return CDef.ProductCategory.codeOf(code); }
            if ("ProductStatus".equals(name())) { return CDef.ProductStatus.codeOf(code); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        @Override
        public Classification nameOf(String name) {
            if ("Flg".equals(name())) { return CDef.Flg.valueOf(name); }
            if ("MemberStatus".equals(name())) { return CDef.MemberStatus.valueOf(name); }
            if ("ServiceRank".equals(name())) { return CDef.ServiceRank.valueOf(name); }
            if ("Region".equals(name())) { return CDef.Region.valueOf(name); }
            if ("WithdrawalReason".equals(name())) { return CDef.WithdrawalReason.valueOf(name); }
            if ("ProductCategory".equals(name())) { return CDef.ProductCategory.valueOf(name); }
            if ("ProductStatus".equals(name())) { return CDef.ProductStatus.valueOf(name); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        @Override
        public List<Classification> listAll() {
            if ("Flg".equals(name())) { return toClassificationList(CDef.Flg.listAll()); }
            if ("MemberStatus".equals(name())) { return toClassificationList(CDef.MemberStatus.listAll()); }
            if ("ServiceRank".equals(name())) { return toClassificationList(CDef.ServiceRank.listAll()); }
            if ("Region".equals(name())) { return toClassificationList(CDef.Region.listAll()); }
            if ("WithdrawalReason".equals(name())) { return toClassificationList(CDef.WithdrawalReason.listAll()); }
            if ("ProductCategory".equals(name())) { return toClassificationList(CDef.ProductCategory.listAll()); }
            if ("ProductStatus".equals(name())) { return toClassificationList(CDef.ProductStatus.listAll()); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        @Override
        public List<Classification> groupOf(String groupName) {
            if ("Flg".equals(name())) { return toClassificationList(CDef.Flg.groupOf(groupName)); }
            if ("MemberStatus".equals(name())) { return toClassificationList(CDef.MemberStatus.groupOf(groupName)); }
            if ("ServiceRank".equals(name())) { return toClassificationList(CDef.ServiceRank.groupOf(groupName)); }
            if ("Region".equals(name())) { return toClassificationList(CDef.Region.groupOf(groupName)); }
            if ("WithdrawalReason".equals(name())) { return toClassificationList(CDef.WithdrawalReason.groupOf(groupName)); }
            if ("ProductCategory".equals(name())) { return toClassificationList(CDef.ProductCategory.groupOf(groupName)); }
            if ("ProductStatus".equals(name())) { return toClassificationList(CDef.ProductStatus.groupOf(groupName)); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        @SuppressWarnings("unchecked")
        private List<Classification> toClassificationList(List<?> clsList) {
            return (List<Classification>)clsList;
        }

        @Override
        public ClassificationCodeType codeType() {
            if ("Flg".equals(name())) { return ClassificationCodeType.Number; }
            if ("MemberStatus".equals(name())) { return ClassificationCodeType.String; }
            if ("ServiceRank".equals(name())) { return ClassificationCodeType.Number; }
            if ("Region".equals(name())) { return ClassificationCodeType.Number; }
            if ("WithdrawalReason".equals(name())) { return ClassificationCodeType.String; }
            if ("ProductCategory".equals(name())) { return ClassificationCodeType.String; }
            if ("ProductStatus".equals(name())) { return ClassificationCodeType.String; }
            return ClassificationCodeType.String; // as default
        }

        @Override
        public ClassificationUndefinedHandlingType undefinedHandlingType() {
            if ("Flg".equals(name())) { return ClassificationUndefinedHandlingType.EXCEPTION; }
            if ("MemberStatus".equals(name())) { return ClassificationUndefinedHandlingType.EXCEPTION; }
            if ("ServiceRank".equals(name())) { return ClassificationUndefinedHandlingType.EXCEPTION; }
            if ("Region".equals(name())) { return ClassificationUndefinedHandlingType.EXCEPTION; }
            if ("WithdrawalReason".equals(name())) { return ClassificationUndefinedHandlingType.EXCEPTION; }
            if ("ProductCategory".equals(name())) { return ClassificationUndefinedHandlingType.EXCEPTION; }
            if ("ProductStatus".equals(name())) { return ClassificationUndefinedHandlingType.EXCEPTION; }
            return ClassificationUndefinedHandlingType.LOGGING; // as default
        }
    }
}
