app_state = {  
	page: CreateMeeting,  
	meeting_input: {  
		meeting_type: "",  
		duration_min: "",  
		deep_dive: "",  
		drift: "",  
		environment: ""  
	}  
} 
  
ui_state = {  
	selected_item: meeting_type  
}

events = [
	KeyPress(Tab),
	KeyPress(Enter) ,
	MouseClick ,
	m -> focus meeting_type , 
	u -> focus duration_min  ,
	e -> focus deep_dive  ,
	r -> focus drift  ,
	n -> focus environment
]

Render

	[m]eeting_type  ____  
	d[u]ration_min  ____
	d[e]ep_dive     ____
	d[r]ift         ____
	e[n]vironment   ____
	
	BTN clear       BTN save
