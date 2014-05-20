I need this program in order to send UDP notification packets. I also plan to make a UDP Hole Punching
in order to make a UDP streaming behind the firewalls but that's just a plan. This project not a big shot,
just an experimental tryout.

Plan to make a multithreaded notification engine for each port so a pool must be used. May be the 
triggering mechanism should be done with a tcp packet payload stores the STATUS (ON|OFF) or something
like that. A restful web service returning a JSON or XML can also be used.