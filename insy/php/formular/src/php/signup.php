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
      ini_set("display_errors", 1);
      ini_set("display_startup_errors", 1);
      error_reporting(E_ALL);

      $servername = "mariadb";
      $username = "root";
      $password = "admin";
      $dbname = "viennabybike";

      $conn = null;

      try {
          $conn = new PDO(
              "mysql:host=$servername;dbname=$dbname;charset=utf8",
              $username,
              $password
          );
          $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
      } catch (PDOException $e) {
          die(
              "<p style='color:red;'>Database Connection Failed: " .
                  htmlspecialchars($e->getMessage()) .
                  "</p>"
          );
      }

      if ($_SERVER["REQUEST_METHOD"] == "POST") {
          try {
              if (
                  !isset(
                      $_POST["firstname"],
                      $_POST["lastname"],
                      $_POST["email"],
                      $_POST["street"],
                      $_POST["number"],
                      $_POST["postal_code"],
                      $_POST["city"],
                      $_POST["phone"],
                      $_POST["id_type"],
                      $_POST["id_number"]
                  )
              ) {
                  throw new Exception(
                      "Critical form field missing in submission. Ensure 'id_number' field exists in your HTML form."
                  );
              }

              $stmt_max_id = $conn->query(
                  "SELECT MAX(kid) AS max_id FROM kunden"
              );
              $max_id_row = $stmt_max_id->fetch(PDO::FETCH_ASSOC);
              $next_kid =
                  $max_id_row && $max_id_row["max_id"] !== null
                      ? $max_id_row["max_id"] + 1
                      : 1;

              $sql = "INSERT INTO kunden (kid, vorname, nachname, strasse, ort, plz, land, email, telefon, ausweisnr, ausweistyp)
                      VALUES (:kid, :vorname, :nachname, :strasse, :ort, :plz, :land, :email, :telefon, :ausweisnr, :ausweistyp)";

              $stmt = $conn->prepare($sql);

              $firstname_raw = trim($_POST["firstname"]);
              $lastname_raw = trim($_POST["lastname"]);
              $street_raw = trim($_POST["street"]);
              $number_raw = trim($_POST["number"]);
              $city_raw = trim($_POST["city"]);
              $postal_code_raw = trim($_POST["postal_code"]);
              $email_raw = trim($_POST["email"]);
              $phone_raw = trim($_POST["phone"]);
              $form_id_type_raw = trim($_POST["id_type"]);
              $id_number_raw = trim($_POST["id_number"]);

              $strasse_combined_raw = $street_raw . " " . $number_raw;

              $land_raw = "Österreich";

              $db_ausweistyp = "";
              switch ($form_id_type_raw) {
                  case "reisepass":
                      $db_ausweistyp = "pass";
                      break;
                  case "personalausweis":
                      $db_ausweistyp = "paw";
                      break;
                  case "fuehrerschein":
                      $db_ausweistyp = "fs";
                      break;
                  default:
                      throw new Exception(
                          "Invalid ID Type value selected: " .
                              htmlspecialchars($form_id_type_raw)
                      );
              }

              if (
                  empty($firstname_raw) ||
                  empty($lastname_raw) ||
                  empty($street_raw) ||
                  empty($city_raw) ||
                  empty($postal_code_raw) ||
                  empty($email_raw) ||
                  empty($phone_raw) ||
                  empty($id_number_raw) ||
                  empty($db_ausweistyp)
              ) {
                  throw new Exception(
                      "Please fill in all required fields correctly."
                  );
              }
              if (!filter_var($email_raw, FILTER_VALIDATE_EMAIL)) {
                  throw new Exception("Invalid email format provided.");
              }

              $firstname_safe = htmlspecialchars(
                  $firstname_raw,
                  ENT_QUOTES,
                  "UTF-8"
              );
              $lastname_safe = htmlspecialchars(
                  $lastname_raw,
                  ENT_QUOTES,
                  "UTF-8"
              );
              $strasse_combined_safe = htmlspecialchars(
                  $strasse_combined_raw,
                  ENT_QUOTES,
                  "UTF-8"
              );
              $city_safe = htmlspecialchars($city_raw, ENT_QUOTES, "UTF-8");
              $postal_code_safe = htmlspecialchars(
                  $postal_code_raw,
                  ENT_QUOTES,
                  "UTF-8"
              );
              $land_safe = htmlspecialchars($land_raw, ENT_QUOTES, "UTF-8");
              $email_safe = htmlspecialchars($email_raw, ENT_QUOTES, "UTF-8");
              $phone_safe = htmlspecialchars($phone_raw, ENT_QUOTES, "UTF-8");
              $id_number_safe = htmlspecialchars(
                  $id_number_raw,
                  ENT_QUOTES,
                  "UTF-8"
              );

              $stmt->bindParam(":kid", $next_kid, PDO::PARAM_INT);
              $stmt->bindParam(":vorname", $firstname_safe);
              $stmt->bindParam(":nachname", $lastname_safe);
              $stmt->bindParam(":strasse", $strasse_combined_safe);
              $stmt->bindParam(":ort", $city_safe);
              $stmt->bindParam(":plz", $postal_code_safe);
              $stmt->bindParam(":land", $land_safe);
              $stmt->bindParam(":email", $email_safe);
              $stmt->bindParam(":telefon", $phone_safe);
              $stmt->bindParam(":ausweisnr", $id_number_safe);
              $stmt->bindParam(":ausweistyp", $db_ausweistyp);

              $stmt->execute();

              echo "<div class='container'>";
              echo "<h1>Signup Information</h1>";
              echo "<p style='color:green;'>Signup successful! Welcome! Your Customer ID is: " .
                  htmlspecialchars((string) $next_kid) .
                  "</p>";

              echo "<h2>Summary:</h2>";
              echo "<p><strong>Customer ID:</strong> " .
                  htmlspecialchars((string) $next_kid) .
                  "</p>";
              echo "<p><strong>First Name:</strong> " .
                  $firstname_safe .
                  "</p>";
              echo "<p><strong>Last Name:</strong> " . $lastname_safe . "</p>";
              echo "<p><strong>Address:</strong> " .
                  $strasse_combined_safe .
                  ", " .
                  $postal_code_safe .
                  " " .
                  $city_safe .
                  ", " .
                  $land_safe .
                  "</p>";
              echo "<p><strong>Email:</strong> " . $email_safe . "</p>";
              echo "<p><strong>Phone:</strong> " . $phone_safe . "</p>";
              echo "<p><strong>ID Type:</strong> " .
                  htmlspecialchars($form_id_type_raw) .
                  "</p>";
              echo "<p><strong>ID Number:</strong> **********</p>";
              echo "</div>";
          } catch (PDOException $e) {
              echo "<div class='container'>";
              echo "<h1>Signup Error</h1>";
              echo "<p style='color:red;'>Database Error: Could not process your signup. Please try again later.</p>";
              echo "</div>";
          } catch (Exception $e) {
              echo "<div class='container'>";
              echo "<h1>Signup Error</h1>";
              echo "<p style='color:red;'>Error: " .
                  htmlspecialchars($e->getMessage()) .
                  "</p>";
              echo "<p><a href='javascript:history.back()'>Go back and correct the form</a></p>";
              echo "</div>";
          }
      } else {
          echo "<div class='container'>";
          echo "<h1>Signup</h1>";
          echo "<p>This page processes signup information. Please use the signup form.</p>";
          echo "</div>";
      }

      $conn = null;
      ?>
    </div>
</body>
</html>
