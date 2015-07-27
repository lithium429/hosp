package com.xz.oa.core.domain.entity;


public class MealMenuAddUp extends MealMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7904906292522389783L;

	//订餐种类（A|B|C）集合
	private java.lang.String meat_types;
	
	//订餐数量集合
	private java.lang.String count_nums;
	
	//订餐名称集合
	private java.lang.String food_names;
	
	//合计数量
	private java.lang.Integer total_count;

	public java.lang.String getMeat_types() {
		return meat_types;
	}

	public void setMeat_types(java.lang.String meat_types) {
		this.meat_types = meat_types;
	}

	public java.lang.String getCount_nums() {
		return count_nums;
	}

	public void setCount_nums(java.lang.String count_nums) {
		this.count_nums = count_nums;
	}

	public java.lang.String getFood_names() {
		return food_names;
	}

	public void setFood_names(java.lang.String food_names) {
		this.food_names = food_names;
	}

	public java.lang.Integer getTotal_count() {
		return total_count;
	}

	public void setTotal_count(java.lang.Integer total_count) {
		this.total_count = total_count;
	}
	
	//获取食物数量
	public int gainFood_num(int meat_type)
	{
		int r=0;
		int index=0;
		String[] typeArray=this.meat_types.split(","),countArray=this.count_nums.split(",");
		for (int i = 0; i < typeArray.length; i++) {
			if(typeArray[i].equals(String.valueOf(meat_type)))
			{
				index=i;
				break;
			}
		}
		r=Integer.valueOf(countArray[index]);
		return r;
	}
	
	//获取食物名称
	public String gainFood_name(int meat_type)
	{
		String r="";
		int index=0;
		String[] typeArray=this.meat_types.split(","),nameArray=this.food_names.split(",");
		for (int i = 0; i < typeArray.length; i++) {
			if(typeArray[i].equals(String.valueOf(meat_type)))
			{
				index=i;
				break;
			}
		}
		r=nameArray[index];
		return r;
	}
	
}
