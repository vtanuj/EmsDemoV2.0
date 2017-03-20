/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems.util;

import ems.model.MyModel;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tanujv
 */
public class Constants {
    //Splash
    public static final String HEADER_SPLASH = "e-Solutions Election Management System";
    //Login
    public static final String TITLE_LOGIN = "Login Title";
    public static final String HEADER_LOGIN = "Header Login";
    //Home
    public static final String TITLE_HOME = "e-Solutions Election Management System";
    public static final String HEADER_HOME = "e-Solutions Election Management System";
    //Images
    public static final String IMAGE_FAVICON = "/ems/media/images/favicon.png";
    public static final String IMAGE_SPLASH = "/ems/media/images/splash.jpg";
    public static final String IMAGE_LOGO = "/ems/media/images/logo.jpg";
    //About
    public static final String TITLE_ABOUT = "e-Solutions";
    public static final String HEADER_ABOUT = "Election Management System";
    public static final String VENDOR_NAME = "e-Solutions";
    public static final String VERSION = "1.0.0.0";
    //Paths
    public static final String PATH_TEMP = "./temp";
    public static final String PATH_LOCK_FILE = PATH_TEMP + "/system.lock";
    public static final String PATH_AUTH_DB = PATH_TEMP + "/auth.dll";
    public static final String PATH_TEMP_DB = "/ems/temp/temp.dll";

    public static final String PATH_FONT = "/ems/media/font/fontawesome-webfont.ttf";
    public static final String PATH_FONT_UNICODE = "/ems/media/font/ARIALUNI_1.TTF";
    public static final String PATH_FONT_UNICODE_ = PATH_TEMP + "/ARIALUNI_1.TTF";

    public static final String PATH_TEMP_DB_ = PATH_TEMP + "/temp.dll";

    public static final String PATH_REPORT_1 = "/ems/reports/Report1.jasper";
    public static final String PATH_REPORT_1_ = PATH_TEMP + "/Report1.jasper";
    public static final String PATH_REPORT_2 = "/ems/reports/Report2.jasper";
    public static final String PATH_REPORT_2_ = PATH_TEMP + "/Report2.jasper";
    public static final String PATH_REPORT_3 = "/ems/reports/Report3.jasper";
    public static final String PATH_REPORT_3_ = PATH_TEMP + "/Report3.jasper";
    public static final String PATH_REPORT_4 = "/ems/reports/Report4.jasper";
    public static final String PATH_REPORT_4_ = PATH_TEMP + "/Report4.jasper";

    public static final List<MyModel> REPORTS_TYPE = new LinkedList<>();
    public static final List<MyModel> MONTHS = new LinkedList<>();
    public static final List<MyModel> COLORS = new LinkedList<>();
    public static final List<MyModel> GENDER = new LinkedList<>();

    static {
        REPORTS_TYPE.add(new MyModel("0", "Choose Report"));
        REPORTS_TYPE.add(new MyModel("1", "Age Wise"));
        REPORTS_TYPE.add(new MyModel("2", "Alphabetic Wise"));
        REPORTS_TYPE.add(new MyModel("3", "Area Wise"));
        REPORTS_TYPE.add(new MyModel("4", "Birthday List"));
        REPORTS_TYPE.add(new MyModel("5", "Birthday List Date Wise"));
        REPORTS_TYPE.add(new MyModel("6", "Booth Wise - Matdar Yadi"));
        REPORTS_TYPE.add(new MyModel("7", "Community Wise"));
        REPORTS_TYPE.add(new MyModel("8", "Color Code Booth Wise"));
        REPORTS_TYPE.add(new MyModel("9", "Color Code Wise"));
        REPORTS_TYPE.add(new MyModel("10", "Mobile Wise"));
        REPORTS_TYPE.add(new MyModel("11", "Section Wise"));
        REPORTS_TYPE.add(new MyModel("12", "Surname Wise"));
        REPORTS_TYPE.add(new MyModel("13", "Without ID Card List"));

        MONTHS.add(new MyModel("00", "Choose Month"));
        MONTHS.add(new MyModel("01", "January"));
        MONTHS.add(new MyModel("02", "February"));
        MONTHS.add(new MyModel("03", "March"));
        MONTHS.add(new MyModel("04", "April"));
        MONTHS.add(new MyModel("05", "May"));
        MONTHS.add(new MyModel("06", "June"));
        MONTHS.add(new MyModel("07", "July"));
        MONTHS.add(new MyModel("08", "August"));
        MONTHS.add(new MyModel("09", "September"));
        MONTHS.add(new MyModel("10", "October"));
        MONTHS.add(new MyModel("11", "November"));
        MONTHS.add(new MyModel("12", "December"));

        COLORS.add(new MyModel("0", "Choose Color"));
        COLORS.add(new MyModel("1", "Our"));
        COLORS.add(new MyModel("2", "Opposite"));
        COLORS.add(new MyModel("3", "Unpredictable"));
        COLORS.add(new MyModel("4", "Others"));
        COLORS.add(new MyModel("5", "All"));

        GENDER.add(new MyModel("M", "Male"));
        GENDER.add(new MyModel("F", "Female"));
    }

    public static final String[] REPORT_COLUMN_HEADERS = {"Ward No", "Ward Sr No", "New Sr No.", "Name", "Sex",
        "Age", "ID Card No.", "Mobile No.", "DOB", "Language", "Booth Name"};

    public static final String Q_S_DASHBOARD_CAST_WISE
            = "select "
            + "ifnull(UPPER(trim(cast_nm)),'OTHERS') cast, "
            + "count(*)'No' "
            + "from e_details "
            + "group by UPPER(trim(cast_nm)) "
            + "order by 1";

    public static final String Q_S_DASHBOARD_GENDER_WISE
            = "select "
            + "ifnull(case when trim(sex)='M' then 'Male' when trim(sex)='F' then 'Female' end,'OTHERS') gender, "
            + "count(*)'No' "
            + "from e_details "
            + "group by trim(sex)"
            + "order by 1";

    public static final String Q_S_DASHBOARD_COLOR_WISE
            = "select "
            + "case "
            + "when star_vote=1 then 'Our' "
            + "when star_vote=2 then 'Opposite' "
            + "when star_vote=3 then 'Unpredictable' "
            + "when star_vote=4 then 'Others' "
            + "when star_vote=5 then 'All' "
            + "end, "
            + "count(*)'No' "
            + "from e_details "
            + "group by star_vote "
            + "order by 1";

    public static final String Q_S_GET_VOTER
            = "select "
            + "a.ward_no, "
            + "ifnull(ac_no,'') || '/' || ifnull(part_no,'') || '/' || ifnull(serialinpart,''), "
            + "a.WardSr_No, "
            + "a.slno, "
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.address,''), "
            + "ifnull(b.booth_no,'') || ' - ' || ifnull(b.booth_name_en,''), "
            + "ifnull(a.email_id,''), "
            + "ifnull(a.mobile_no,''), "
            + "ifnull(a.altr_mobile_no,''), "
            + "ifnull(strftime('%%Y-%%m-%%d', a.DOB),''),"
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Cast_nm,''), "
            + "ifnull(a.star_vote,''), "
            + "trim(ifnull(a.UnicodeSurName,'')) || '  ' || trim(ifnull(a.UnicodeFirstName,'')) 'NameUnicode' "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.ward_no=%s and a.WardSr_No=%s";

    public static final String Q_U_VOTER_DETAILS
            = "update e_details set  "
            + "email_id='%s', "
            + "Mobile_no='%s', "
            + "altr_mobile_no='%s', "
            + "DOB='%s', "
            + "star_vote='%s', "
            + "Cast_nm='%s', "
            + "SEX='%s' "
            + "where ward_no=%s and WardSr_No=%s";

    public static final String Q_U_VOTER_STATUS
            = "update e_details set  "
            + "star_vote='%s' "
            + "where ward_no=%s and WardSr_No=%s";

    public static final String Q_S_AGE_WISE
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s and a.AGE > %s and a.AGE < %s "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_ALPHABETIC_WISE
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_AREA_WISE
            = "select "
            + "address, "
            + "count(*) "
            + "from e_details "
            + "where booth_no=%s and address is not null and address<>'' "
            + "group by address "
            + "order by address";

    public static final String Q_S_AREA_WISE_
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s and address='%s' "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_BIRTHDAY_WISE
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s and strftime('%%m', a.DOB)='%s' "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_BIRTHDAY_DAY_WISE
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s and  strftime('%%m-%%d', a.DOB)=substr('%s',6,5) "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_BOOTH_WISE
            = "select "
            + "b.booth_name_en, "
            + "count(*) "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where b.booth_name_en is not null and b.booth_name_en<>'' "
            + "group by b.booth_name_en "
            + "order by b.booth_name_en";

    public static final String Q_S_BOOTH_WISE_
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where booth_name_en='%s' "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_COMMUNITY_WISE
            = "select "
            + "Cast_nm, "
            + "count(*) "
            + "from e_details "
            + "where booth_no=%s and Cast_nm is not null and Cast_nm<>'' "
            + "group by Cast_nm "
            + "order by Cast_nm";

    public static final String Q_S_COMMUNITY_WISE_
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s and Cast_nm='%s' "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_COMMUNITY_STATUS
            = "select "
            + "Cast_nm, "
            + "count(*) "
            + "from e_details "
            + "where  Cast_nm is not null and Cast_nm<>'' "
            + "group by Cast_nm "
            + "order by Cast_nm";

    public static final String Q_S_COMMUNITY_STATUS_
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where Cast_nm='%s' "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_COLOR_CODE_WISE
            = "select "
            + "case "
            + "when star_vote=1 then 'Our' "
            + "when star_vote=2 then 'Opposite' "
            + "when star_vote=3 then 'Unpredictable' "
            + "when star_vote=4 then 'Others' "
            + "when star_vote=5 then 'All' "
            + "end, "
            + "count(*) "
            + "from e_details "
            + "where star_vote is not null and star_vote<>'' "
            + "and (5=%s or star_vote=%s) "
            + "group by star_vote "
            + "order by 1";

    public static final String Q_S_COLOR_CODE_WISE_
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where (5=%s or star_vote=%s) "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_COLOR_CODE_BOOTH_WISE
            = "select "
            + "case "
            + "when star_vote=1 then 'Our' "
            + "when star_vote=2 then 'Opposite' "
            + "when star_vote=3 then 'Unpredictable' "
            + "when star_vote=4 then 'Others' "
            + "when star_vote=5 then 'All' "
            + "end, "
            + "count(*) "
            + "from e_details "
            + "where booth_no=%s and star_vote is not null and star_vote<>'' "
            + "and (5=%s or star_vote=%s) "
            + "group by star_vote "
            + "order by star_vote";

    public static final String Q_S_COLOR_CODE_BOOTH_WISE_
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s and (5=%s or star_vote=%s) "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_MOBILE_WISE
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s and length(trim(a.Mobile_no))=10 "
            + "order by a.FirstNameEnglish";
    public static final String Q_S_SECTION_WISE
            = "select "
            + "section_no, "
            + "count(*) "
            + "from e_details "
            + "where booth_no=%s and section_no is not null and trim(section_no)<>'' "
            + "group by section_no "
            + "order by section_no";

    public static final String Q_S_SETION_WISE_
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s and section_no='%s' "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_SURNAME_WISE
            = "select "
            + "SurNameEnglish, "
            + "count(*) "
            + "from e_details "
            + "where booth_no=%s and SurNameEnglish is not null and trim(SurNameEnglish)<>'' "
            + "group by SurNameEnglish "
            + "order by SurNameEnglish";

    public static final String Q_S_SURNAME_WISE_
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s and SurNameEnglish='%s' "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_SURNAME_STATUS
            = "select "
            + "SurNameEnglish, "
            + "count(*) "
            + "from e_details "
            + "where SurNameEnglish is not null and trim(SurNameEnglish)<>'' "
            + "group by SurNameEnglish "
            + "order by SurNameEnglish";

    public static final String Q_S_SURNAME_STATUS_
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where SurNameEnglish='%s' "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_WITHOUT_ID_CARD_WISE
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.booth_no=%s and  (a.CardNo is null or length(trim(a.CardNo))<>10) "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_NAME_WISE
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.FirstNameEnglish like '%s%%' and a.SurNameEnglish like '%s%%' "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_ID_WISE
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.CardNo like '%s%%' "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_SR_WISE
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.WardSr_No,''),"
            + "IFNULL(a.slno,''),"
            + "trim(ifnull(a.SurNameEnglish,'')) || '  ' || trim(ifnull(a.FirstNameEnglish,'')) 'Name', "
            + "ifnull(a.SEX,''),"
            + "ifnull(a.AGE,''),"
            + "ifnull(a.CardNo,''),"
            + "ifnull(a.Mobile_no,''),"
            + "ifnull(strftime('%%d-%%m-%%Y', a.DOB),''),"
            + "ifnull(a.Cast_nm,''),"
            + "ifnull(b.booth_name_en,'') "
            + "from e_details a "
            + "left join booth_master b on a.booth_no=b.booth_no "
            + "where a.WardSr_No=%s "
            + "order by a.FirstNameEnglish";

    public static final String Q_S_ELECTION_HISTORY
            = "select "
            + "ifnull(a.ward_no,''),"
            + "ifnull(a.cnd_name,''),"
            + "IFNULL(a.party,''),"
            + "ifnull(a.t_vote,'') "
            + "from bmc_history a "
            + "where a.ward_no=%s "
            + "order by a.cnd_name";
}
