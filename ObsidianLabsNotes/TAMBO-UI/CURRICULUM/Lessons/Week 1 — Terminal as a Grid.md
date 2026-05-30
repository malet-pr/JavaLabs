## Lesson 1.1 — The Terminal Is Not Text

The first misconception almost everyone has:

> A terminal is a place where text appears line by line.

Historically that's how we use it.

A TUI library sees something different:

┌──────-─┐
│                     │
│                     │
│                     │
│                     │
└─────-──┘

A TUI sees a **2D matrix of cells**.

Something like:

```
(0,0) (1,0) (2,0) (3,0)
(0,1) (1,1) (2,1) (3,1)
(0,2) (1,2) (2,2) (3,2)
```

Each position contains a cell.

Conceptually:

```
Cell {    
	char symbol;    
	Color foreground;    
	Color background;    
	Style style;
}
```

The important realization:

> The terminal is closer to a spreadsheet than to a text file.

---

## Coordinates

Suppose your terminal is:
	80 columns
	24 rows

Then:
	x = 0..79
	y = 0..23

The top-left corner is: (0,0)
A point near the center: (40,12)

A TUI library constantly thinks in coordinates.

---

## Why TamboUI Uses Areas

Imagine:
┌─────────────┐
│ Menu                         │
├─────────────┤
│ Item 1                        │
│ Item 2                        │
│ Item 3                        │
└─────────────┘
You could draw this cell by cell.
Nobody does.
Instead you define a rectangle:
	x = 0
	y = 0
	width = 15
	height = 6
This rectangle becomes an **Area**.

That's why most modern TUI libraries have some variation of:
	Area
	Rect
	Rectangle
	Region

They're all representing:
	start position
	+
	width
	+
	height

---
## Mental Exercise

Imagine your terminal is: 80 x 24
You want:
+----------------------+
| Menu                        |
+----------------------+
+--------------------------------------+
| Main Content                                   |
|                                                           |
|                                                           |
+--------------------------------------+
Without worrying about code:
1. What rectangle would you assign to the Menu?
2. What rectangle would you assign to Main Content?
3. If the terminal becomes 120×40, should those rectangles remain fixed or grow?

That question is the seed of **layout systems**, which is Week 4.
Even better: when you answer it, try to separate: `Application State` from `UI State` 
because that distinction becomes crucial when we reach Week 5 and Week 6. In fact, your Blessed state machine TUI already contained both, even if we didn't call them by those names at the time.