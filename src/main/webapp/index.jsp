<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Permet d'être responsive (pour smartphones, tablettes) : la largeur de la page doit être égale à la largeur de l'appareil (width=device-width), et l'échelle initiale de la page est définie à 1.0 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="page-encherir" content="Ceci est la page d'accueil de la plateforme de vente aux encheres de l'association"> <!-- intéressant pour le référencement -->
    <link rel="stylesheet" href="PageAccueilNonConnecte.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-q50NyzKTj7J8r6Rr5zfg7sS8UfTchXEBIsEwbUjB+0UgV3AdTYIDwROg+CPLGz48zynrViMFn9p3OxX5x/TbCw==" crossorigin="anonymous" referrerpolicy="no-referrer" /> <!-- pour l'icône de loupe de la biblio Font Awesome -->

    <title>
        Page Accueil Non Connecte
    </title>
</head>
<body>
    <header>
        <h1>ASSOCIATION |  Les Objets Sont Nos Amis</h1>
        <!-- <aside> </aside> pour une bandeau publicitaire ? -->

            <nav> <!-- Barre de navigation (en haut à droite de la page) -->
                <div id="navigation">
                    <a href="ServletConnexion">Se connecter</a>
                    <a href="ServletInscription">S'inscrire</a>

                </div>
            </nav>

            <class img src="https://ik.imagekit.io/uwzsb7j5w/wp-content/uploads/sites/2/2022/10/Les-encheres-en-ligne-mode-d-emploi.jpg" alt="Illustration vente enchères online"  width=10% height=10%>
    </header>

    <main>
        <h2>Liste des enchères</h2>
                    <form action="" id="bonjour" method="GET">

        <h3>Filtres :
            <div class="search-container">
                <input type="text" id="search-input" name="search-input" placeholder="Le nom de l'article contient...">
                <input type="submit" value="Rechercher" />
            </div>
        </h3>

        <label for="listeCategories">Catégorie : </label>
        <select form="bonjour" id="listeCategories" name="listeCategories">
            <option value="-1">Toutes</option>
            <c:forEach var="c" items="${listeCategories}">
                <option ${c.noCategorie==categorie?"selected":""} value="${c.noCategorie}">${c.libelle}</option>
            </c:forEach>

            <!-- Liste déroulante des articles par catégorie-->
        </select>


        <c:forEach var="a" items="${listeArticles}">
            <div class="cadre-container">
                <div class="cadre">
                     <div class="texte">
                         <p class="first-line">${a.nom}</p>
                         <c:forEach items="${a.nom}">
                             <p>Description : ${a.description}</p>
                         </c:forEach>
                     </div>
                </div>
            </div>
        </c:forEach>




</form>

        <div class="cadre-container">
            <div class="cadre">
                <img src="\1-13_Page_Accueil_Non_Connecte\PCGamer.jpg" alt="Image 1">
                <div class="texte">
                    <p class="first-line">PC Gamer pour travailler</p>
                    <p><span>Prix:</span> 210 points</p>
                    <p><span>Fin de l'enchère:</span> 15/02/2024</p>
                    <p><span>Vendeur:</span> jojo44</p>
                </div>
            </div>

            <div class="cadre">
                <img src="\1-13_Page_Accueil_Non_Connecte\RocketStove.webp" alt="Image 2">
                <div class="texte">
                    <p class="first-line">Rocket stove</p>
                    <p><span>Prix:</span> 185 points</p>
                    <p><span>Fin de l'enchère:</span> 31/03/2024</p>
                    <p><span>Vendeur:</span> JaneMary420</p>
                </div>
            </div>
        </div>

        <div class="cadre-container">
            <div class="cadre">
                <img src="\1-13_Page_Accueil_Non_Connecte\DetecteurMetaux.jpg" alt="Image 1">
                <div class="texte">
                    <p class="first-line">Détecteur de métaux</p>
                    <p><span>Prix:</span> 80 points</p>
                    <p><span>Fin de l'enchère:</span> 01/03/2024</p>
                    <p><span>Vendeur:</span> Golden77</p>
                </div>
            </div>

            <div class="cadre">
                <img src="\1-13_Page_Accueil_Non_Connecte\raclette.jpg" alt="Image 2">
                <div class="texte">
                    <p class="first-line">Kit à raclette</p>
                    <p><span>Prix:</span> 75 points</p>
                    <p><span>Fin de l'enchère:</span> 20/03/2024</p>
                    <p><span>Vendeur:</span> Cheesy3</p>
                </div>
            </div>
        </div>

    </main>

    <footer>
        <p class="italic-text"><h2>ENI Ecole Informatique - Projet Enchères - 2024</h2></p>
    </footer>

    <form>
        <input type="button" value="<" onclick="history.go(-1);">
    </form> <br>
    <form>
        <input type="button" value="<<" onclick="history.go(-2);">
    </form>
    <!-- Boutons rafraîchir et retour du navigateur (liste exigence: ID:6001) -->

</body>


</html>