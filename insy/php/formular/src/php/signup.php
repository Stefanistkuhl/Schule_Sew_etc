<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup Information</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --bg-color: #faf4ed;
            --text-color: #575279;
        }

        body {
            font-family: 'Roboto', sans-serif;
            background-color: var(--bg-color);
            color: var(--text-color);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        .container {
            background-color: white;
            padding: 2rem;
            border-radius: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h1 {
            color: var(--text-color);
            margin-bottom: 2rem;
        }

        p {
            margin: 0.5rem 0;
        }

        .label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Signup Information</h1>
        <?php
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            foreach ($_POST as $key => $value) {
                $sanitizedValue = htmlspecialchars(strip_tags(trim($value)), ENT_QUOTES, 'UTF-8');
                echo "<p><strong>" . htmlspecialchars($key) . ":</strong> " . $sanitizedValue . "</p>";
            }
        } else {
            echo "<p>No data received</p>";
        }
        ?>
    </div>
</body>
</html>
