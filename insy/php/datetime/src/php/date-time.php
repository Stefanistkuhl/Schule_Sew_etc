<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>aisdiafjiajfiasjfiasjfij</title>
</head>

<body>
	<?php
	$today = getdate();
	echo "Stunden " . $today['hours'] . ", Minuten " . $today['minutes'] . " und Sekunden " . $today['seconds'] . ".<br>";
	echo "It now is ", $today['hours'], ":", $today['minutes'], ":", $today['seconds'] . ". <br>";
	$tagName = date('l', $today[0]);
	$tagNummer = $today['mday'];
	$monatName = date('F', $today[0]);
	$jahr = $today['year'];
	$stunden = $today['hours'];
	$minuten = $today['minutes'];
	$sekunden = $today['seconds'];

	$deutscheWochentage = [
		'Monday' => 'Montag',
		'Tuesday' => 'Dienstag',
		'Wednesday' => 'Mittwoch',
		'Thursday' => 'Donnerstag',
		'Friday' => 'Freitag',
		'Saturday' => 'Samstag',
		'Sunday' => 'Sonntag',
	];
	$tagNameDeutsch = $deutscheWochentage[$tagName];

	$deutscheMonate = [
		'January' => 'Januar',
		'February' => 'Februar',
		'March' => 'März',
		'April' => 'April',
		'May' => 'Mai',
		'June' => 'Juni',
		'July' => 'Juli',
		'August' => 'August',
		'September' => 'September',
		'October' => 'Oktober',
		'November' => 'November',
		'December' => 'Dezember',
	];
	$monatNameDeutsch = $deutscheMonate[$monatName];

	echo "Heute ist " . $tagNameDeutsch . ", der " . $tagNummer . ". " . $monatNameDeutsch . " " . $jahr . ". Es ist jetzt " . $stunden . ":" . sprintf("%02d", $minuten) . ":" . sprintf("%02d", $sekunden) . ".<br>";
	echo "Today is " . date('l, F j, Y, H:i:s', $today[0]) . ".<br>";

	?>
</body>

</html>
