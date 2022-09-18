function getIP {
(get-netipaddress).ipv4address | Select-String "192*"
}
function getUser{
$env:USERNAME
}
function getHost{
$env:COMPUTERNAME
}
function getDate {
get-date
}
function getVersion{
$PSVersionTable.PSVersion
}
write-host(getIP)
$IP = getIP
$Hostname = getHost
$User = getUser
$Version = getVersion
$DATE = getDate
Write-Host("This Machines IP address is $IP. User is $User. Hostname is $Hostname. The current powershell shell version is $Version. Today's Date is $DATE")