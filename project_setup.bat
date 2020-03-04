@echo off
echo Creating directories...
mkdir "./Input Files"
mkdir "./Input Files/conf"
mkdir "./Input Files/css"
mkdir "./Input Files/js"
mkdir "./Input Files/images"
mkdir "./Output Files"
mkdir "./libs"
echo Done!
echo Creating default config files...
echo >"./Input Files/conf/default.conf"
echo title=Examples/Example1>>"./Input Files/conf/default.conf"
echo extension=html>>"./Input Files/conf/default.conf"
echo clear_output_dir=false>>"./Input Files/conf/default.conf"
echo enable_css=true>>"./Input Files/conf/default.conf"
echo enable_images=true>>"./Input Files/conf/default.conf"
echo enable_js=false>>"./Input Files/conf/default.conf"
echo import_config=true>>"./Input Files/conf/default.conf"
echo use_jquery=false>>"./Input Files/conf/default.conf"
echo use_react=false>>"./Input Files/conf/default.conf"
echo use_angular=false>>"./Input Files/conf/default.conf"
echo use_vue=false>>"./Input Files/conf/default.conf"
echo Done!
echo Downloading libraries...
powershell -Command "(New-Object Net.WebClient).DownloadFile('http://apache.mirror.serversaustralia.com.au//commons/io/binaries/commons-io-2.6-bin.zip', './libs/package.zip')"
echo Done!
echo Extracting libraries...
powershell $global:ProgressPreference = 'SilentlyContinue'; Expand-Archive "./libs/package.zip" -DestinationPath "./libs/package"
cd "./libs/package/commons-io-2.6/"
move "commons-io-2.6.jar" "../../">nul
cd ../../
del package.zip
rmdir /s /q "./package"
echo Done!
echo Finished setting up workspace!
pause