package mdl;


public class Business {
	public double  standard = 0.3;//裂缝标准0.3cm
	public String level_one_alert="一级预警";
	public String level_two_alert="二级预警";
	public String level_three_alert="三级预警";
	public String nomal="正常";
	//模型一：检测气泡线为0.01mm
	public String FirstModel(double crack) {
		
		double pre = (crack-standard)/standard;
		
		if(0.2<=pre&&pre<0.4) {
			return this.level_one_alert;
		}else if (0.4<=pre&&pre<0.6) {
			return this.level_two_alert;
		}else if(pre>=0.6) {
			return this.level_three_alert;
		}
		return this.nomal;
			
	}
	//模型二：检测气泡线为0.05mm
		public String SecendModel(double crack) {
			
			double pre = (crack-standard)/standard;
			
			if(0.2<=pre&&pre<0.4) {
				return this.level_one_alert;
			}else if (0.4<=pre&&pre<0.6) {
				return this.level_two_alert;
			}else if(pre>=0.6) {
				return this.level_three_alert;
			}
			return this.nomal;
				
		}
		//模型三：弯曲损耗原理测混凝土裂缝宽度
		public String ThirdModel(double r,double initial_diameter) {
	//		double  initial_diameter=0.2;//初始直径
	//		double  r;//变形后光纤弯曲段半径
			double  s;//光损耗值
			double b = 0.1;
			double  angle=90;
			double fai=Math.toRadians(angle);
			
			double crack = (initial_diameter-r)*(Math.PI*Math.sin(fai)+2)/(2*Math.sin(fai));
		//	r=initial_diameter-(2*crack*Math.sin(fai)/(Math.PI*Math.sin(fai)+2));
			

			
			double c=initial_diameter-b*crack;
			
			s=422.3*Math.PI*Math.sqrt(c)*Math.pow(Math.E, (-0.7)*c);
			
            double pre = (crack-standard)/standard;
			
			if(0.2<=pre&&pre<0.4) {
				return this.level_one_alert;
			}else if (0.4<=pre&&pre<0.6) {
				return this.level_two_alert;
			}else if(pre>=0.6) {
				return this.level_three_alert;
			}
			return this.nomal;
				
		}	

}
