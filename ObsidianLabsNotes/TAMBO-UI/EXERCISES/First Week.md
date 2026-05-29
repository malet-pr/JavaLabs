### Warm-up

> Design a tiny TamboUI screen for “Rule Runner”: title, selected rule bag, run button, result panel.

No code yet. Just state/events/render. Then we turn that into Java.

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

---

Even better: when you answer it, try to separate: `Application State` from `UI State` 
because that distinction becomes crucial when we reach Week 5 and Week 6. In fact, your Blessed state machine TUI already contained both, even if we didn't call them by those names at the time.


