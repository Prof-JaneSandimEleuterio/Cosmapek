SET DIR_WS=C:\COSMAPEK

forfiles /P %DIR_WS%\DB\orientdb-community-2.1.0\orientdb-community-2.1.0\databases /c "cmd /c del @path /q & rd @path /s /q


PAUSE

cd  %DIR_WS%\DB\orientdb-community-2.1.0\orientdb-community-2.1.0\bin
START "DB Server" server.bat


PAUSE

SET DIR_JARS= %DIR_WS%\GeneratedJars\v2_check

cd %DIR_JARS%\ApiBuscame_A_1723
START "Product A" a.bat
PAUSE

cd %DIR_JARS%\ApiBuscame_B_10000
START "Product B" b.bat
PAUSE

cd %DIR_JARS%\ApiBuscame_C_27070
START "Product C" c.bat
PAUSE

cd %DIR_JARS%\ApiBuscame_D_9418
START "Localization A" d.bat
PAUSE

cd %DIR_JARS%\ApiBuscame_E_9999
START "Localization B" e.bat
PAUSE

cd %DIR_JARS%\ApiBuscame_F_5228
START "Localization C" f.bat
PAUSE

cd %DIR_JARS%\ApiBuscame_G_5222
START "Configuration A" g.bat
PAUSE

cd %DIR_JARS%\ApiBuscame_H_3389
START "Configuration B" h.bat