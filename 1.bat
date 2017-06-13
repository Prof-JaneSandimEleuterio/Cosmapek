START "delete databases" delDatabases.bat

PAUSE

cd C:\COSMAPEK\DB\orientdb-community-2.1.0\orientdb-community-2.1.0\bin
START "DB Server" server.bat


PAUSE

cd C:\COSMAPEK


START "A" a.bat
START "B" b.bat
START "C" c.bat
START "D" d.bat
START "E" e.bat
START "F" f.bat
START "G" g.bat
START "H" h.bat