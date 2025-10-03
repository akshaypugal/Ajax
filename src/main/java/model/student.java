package model;

public class student {
        private int sid  ; 
        private String sname ; 
        private String scourse ; 
        private double sfee ;
		public student(String sname, String scourse, double sfee) {
			super();
			
			this.sname = sname;
			this.scourse = scourse;
			this.sfee = sfee;
		}
		public student(int sid , String sname, String scourse, double sfee) {
			super();
			this.setSid(sid) ; 
			this.sname = sname;
			this.scourse = scourse;
			this.sfee = sfee;
		}
		public student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getScourse() {
			return scourse;
		}
		public void setScourse(String scourse) {
			this.scourse = scourse;
		}
		public double getSfee() {
			return sfee;
		}
		public void setSfee(double sfee) {
			this.sfee = sfee;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		} 
        
        
}
