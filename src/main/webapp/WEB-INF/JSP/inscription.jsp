<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="seb.css">
    <title>Création de compte</title>
</head>

<body>
    <header>
        <h1> ASSOCIATION Les Objets Sont Nos Amis </h1>
    </header>
    <h1> Création de compte utilisateur </h1>
        <h2>ENI-Enchères</h2>

            <h3> Mon profil :</h3>
                <section>
                    <form action="/ServletInscription" method="POST">

                        <label for="pseudo">Pseudo* :</label>
                        <input type="text" id="pseudo" name="pseudo" autofocus required title="Saisissez votre pseudo">

                        <label for="name">Nom* :</label>
                        <input type="name" id="name" name="name" placeholder="DOE" required title="Saisissez votre nom (3 caractères min.)">

                        <br>
                        <br>
                        <label for="first_name">Prénom* :</label>
                        <input type="first_name" id="fisrt_name" name="fisrtName" placeholder="John" required title="Saisissez votre prénom (3 caractères min.)">

                        <label for="email">Email* :</label>
                        <input type="email" id="email" name="email"  placeholder="johndoe@mail.fr" required title="Saissisez votre e-mail">
                        <br>
                        <br>

                        <label for="telephone">Téléphone :</label>
                        <input type="telephone" id="telephone" name="telephone"  pattern="[0-9]" title="Saissisez votre Téléphone">


                        <label for="rue"> Rue/Avenue :</label>
                        <input type="text" id="rue" name="rue" required title="Saissisez votre adresse">
                        <br>
                        <br>

                        <label for="codePostal"> Code postal :</label>
                        <input type="text" id="codePostal" name="codePostal" required pattern="[0-9]" title="Saissisez votre code postal">


                        <label for="ville"> Ville :</label>
                        <input type="text" id="ville" name="ville" required title="Saissisez votre ville">
                        <br>
                        <br>


                        <label for="password">Mot de passe* :</label>
                        <input type="password" id="password" name="password" required title="Saisissez votre mot de passe (8 caractères min.)">

                        <label for="confirmPassword">Confirmation de mot de passe* :</label>
                        <input type="password" id="confirmPassword" name="confirmPassword" required title="Confirmez votre mot de passe (8 caractères min.)">



                        <p>* : Champs obligatoire</p>
                        <br>

                        <br>
                        <br>

                    </form>

                    <div class="container">
                        <button class="button2">
                            <a href=""> Créer </a>
                        </button>
                        <button class="button2">
                            <a href="index.html">Annuler</a>
                        </button>
                    </div>
                <br>
                <br>

            </section>
</body>

<footer>
    <button>
        <a href="monCompte.html">Mon compte</a>
    </button>
</footer>

</html>