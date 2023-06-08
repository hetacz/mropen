$Path = "$PSScriptRoot\creds.txt"
$values = Get-Content $Path | Out-String | ConvertFrom-StringData
java -jar $PSScriptRoot\mropen.jar --username =$( $values.username ) --password = $( $values.password ) --browser = chrome --env = PROD
