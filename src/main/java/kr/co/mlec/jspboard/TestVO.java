package kr.co.mlec.jspboard;

import java.util.Date;

public class TestVO
{
	private int no;
	private Date startDate;
	private Date endDate;
	private Date hourDate;
	private Date modDate;
	private Date modDeDate;
	
	public int getNo()
	{
		return no;
	}
	public void setNo(int no)
	{
		this.no = no;
	}
	public Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}
	public Date getEndDate()
	{
		return endDate;
	}
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
	public Date getHourDate()
	{
		return hourDate;
	}
	public void setHourDate(Date hourDate)
	{
		this.hourDate = hourDate;
	}
	public Date getModDate()
	{
		return modDate;
	}
	public void setModDate(Date modDate)
	{
		this.modDate = modDate;
	}
	public Date getModDeDate()
	{
		return modDeDate;
	}
	public void setModDeDate(Date modDeDate)
	{
		this.modDeDate = modDeDate;
	}	
}
