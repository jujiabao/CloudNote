package org.tarena.cloudnote.entity;
/**
 * 扩展原有的Note实体
 * @author Hello.Ju
 *
 */
public class NoteBean extends Note {
	//追加扩展的属性
	private Long beginTime;
	private Long endTime;
	
	public Long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return "NoteBean [beginTime=" + beginTime + ", endTime=" + endTime
				+ "]";
	}
}
