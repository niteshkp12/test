package com.sadp;

/** 
 * This class represents merged events. The events having having the same group Id merge together to form 
 * one GroupEvent. The text payload of all the events if concatenated to create payload of the GroupEvent.
 * 
 * @author skum73
 *
 */
public class GroupEvent {

	/** the group Id of the event */
	private final long groupId;
	
	/** the payload of the overall group */
	private final long payload;

	public GroupEvent(long groupId, long payload) {
		super();
		this.groupId = groupId;
		this.payload = payload;
	}
	
	public long getGroupId() {
		return groupId;
	}
	
	public long getPayload() {
		return payload;
	}

	@Override
	public String toString() {
		return "GroupEvent [groupId=" + groupId + ", payload=" + payload + "]";
	}
	
}
