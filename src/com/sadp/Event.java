package com.sadp;

public class Event {

	/** a unique id for an event */
	private final long eventId;

	/** groupId of an event */
	private final long groupId;
	
	/** the payload of the event */
	private final String text;
	
	public Event(long eventId, long groupId, String text) {
		super();
		this.eventId = eventId;
		this.groupId = groupId;
		this.text = text;
	}

	public long getEventId() {
		return eventId;
	}

	public long getGroupId() {
		return groupId;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", groupId=" + groupId + ", text="
				+ text + "]";
	}
	
}
