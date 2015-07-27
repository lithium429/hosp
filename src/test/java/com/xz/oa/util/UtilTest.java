/**   
 * @Title: UtilTest.java 
 * @Package: com.xz.oa.util 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-21 下午3:50:15 
 * @version: V1.0   
 */
package com.xz.oa.util;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.joda.time.DateTime;
import org.junit.Ignore;
import org.junit.Test;
import com.alibaba.fastjson.JSON;
import com.xz.base.utils.DESPlus;
import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.DateUtil;
import com.xz.base.utils.SpellUtil;
import com.xz.base.utils.StringUtil;
import com.xz.base.utils.WebUtil;
import com.xz.oa.core.service.file.FileUpload;

public class UtilTest {

	@Ignore
	@Test
	public void testJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", 1);
		map.put("message", "上传文件失败！");
		System.out.println(WebUtil.toJson(map));
	}

	@Ignore
	@Test
	public void testJsonString() {
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("name", "davidwan");
		System.out.println(JSON.toJSONString(obj));
	}

	@Ignore
	@Test
	public void testSpell() {
		String name = "医院";
		System.out.println(SpellUtil.getPinYin(name));
	}

	@Ignore
	@Test
	public void testExt() {
		String ext = FilenameUtils.getExtension("C:\\2014723\111.jpg");
		System.out.println(ext);
	}

	@Ignore
	@Test
	public void testBuildBrowserFileTypes() {
		String extText = ConfigValue.readValue(FileUpload.UPLOAD_FILE_EXT);
		String fileTypes = StringUtil.buildBrowserFileTypes(extText);
		System.out.println(fileTypes);
	}

	@Ignore
	@Test
	public void testMillisecond() {
		String s = DateUtil.dateToStr(DateUtil.getThisYearStart());
		System.out.println(s);
	}

	@Ignore
	@Test
	public void testDateTime() {
		String s = "方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望方大勇张小杰万书德吴本望";
		System.out.println(s.length());
		int c = s.length() / 70;
		System.out.println(c);
		if (s.length() % 70 > 0) {
			c += 1;
		}

		System.out.println(c);
	}

	@Ignore
	@Test
	public void testGainFileNameWithoutPath() {
		String fileName = "C:\\Users\\Administrator\\Desktop\\images\\b_bsp1.jpg";
		fileName = StringUtil.gainFileNameWithoutPath(fileName);
		System.out.println(fileName);
	}

	@Ignore
	@Test
	public void testStartDateOfWeek() {
		Timestamp startDate = DateUtil.getThisWeekStart();
		System.out.print(startDate);
	}

	@Ignore
	@Test
	public void testEndDateOfWeek() {

		DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), sDate_next = sDate.plusWeeks(1), eDate_next = eDate
				.plusWeeks(1), sDate_last = sDate.minusWeeks(1), eDate_last = eDate.minusWeeks(1), sDate_v = sDate.minusWeeks(2), eDate_v = eDate.minusWeeks(2);

		System.out.println(sDate.toString("M月dd日") + "至" + eDate.toString("M月dd日"));
		System.out.println(sDate_next.toString("yyyy-MM-dd") + "至" + eDate_next.toString("yyyy-MM-dd"));
		System.out.println(sDate_last.toString("yyyy-MM-dd") + "至" + eDate_last.toString("yyyy-MM-dd"));
		System.out.println(sDate_v.toString("yyyy-MM-dd") + "至" + eDate_v.toString("yyyy-MM-dd"));
		// System.out.println(DateTime.now().plusWeeks(1));
	}

	@Ignore
	@Test
	public void testPingYin() {
		String text = "NNur";
		String result = SpellUtil.getFullSpell(text);
		String first = SpellUtil.getFirstSpell(text);
		System.out.println(result);
		System.out.println(first);
	}

	@Ignore
	@Test
	public void testSplit() {
		String result = StringUtil.gainSpecifiedElement("1912|davidwan|15156871506|你好", "|", 0);
		System.out.println(result);
	}

	@Test
	public void escapeTextTest() {
		com.xz.base.utils.DESPlus des;
		try {
			// admin 65432021732
			des = new DESPlus();
			String result = des.decrypt("6a62a6f1b4775ff1");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
