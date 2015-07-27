package com.xz.oa.core.service.user;

import java.util.ArrayList; 
import java.util.List;

import com.xz.base.model.ColnameToField;
import com.xz.base.utils.ExportExcel;
import com.xz.oa.core.domain.entity.User;

//统计报表导出
@SuppressWarnings("serial")
public class UserExportExcel extends ExportExcel<User> {

	/**
	 * 
	 * @param dataset数据源
	 * @param path
	 *            导出路径
	 * @param fileName
	 *            导出文件名称
	 * @param title
	 *            文件标题
	 */
	public UserExportExcel(List<User> dataset, String path, String fileName, String title) {
		super(dataset, path);
		// 定义列名与类属性名的对应关系
		//
		List<ColnameToField> colNameToField = new ArrayList<ColnameToField>() {
			{
				add(new ColnameToField("code", "新工号"));
				add(new ColnameToField("name", "老工号"));
				add(new ColnameToField("real_name", "真实姓名"));
				add(new ColnameToField("dept_name", "科室名称"));
			}
		};
		super.setTitle(title);// 标题，以查询的起止日期作为标题
		super.setFileName(fileName);// Excel文件名(以站点名作为文件名)
		super.setDateFormat("yyyy-MM-dd HH:mm:ss");

		// 设置列名对应的属性名集合(其顺序与表头列名属性一致)
		super.setColNameToField(colNameToField);
	}

}