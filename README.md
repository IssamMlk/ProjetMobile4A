# ProjetMobile4A

MALLEK Issam 4AFSI2

<H2>Présentation du projet</H2>
<div align="justify">
Dans le cadre de notre quatrième année, nous sommes ammenés à réaliser un projet mobile. Le but de ce projet est de réaliser une application mobile qui execute un appel API, qui possédent un ou des fragments, une architecture de type MVC; contrairement à l'année passée, nous devions avoir une utilisation plus approfondie de Github (avec plusieurs branch...) et un design plus travaillé.
Cette application affiche une grille de personnage du manga Dragon Ball Z et lors du choix d'un élément de la liste, une fiche détaillé du personnage s'ouvre alors donnant son nom, ses differentes transformations et plusieurs informations complémentaire.</div>

<H2>Consignes respectées:</H2>
<ul>
    <li>Appels <strong>API</strong></li>
    <li>Architecture de type <strong>MVC</strong></li>
    <li>6 Activités:</li> 
    <ol>- <strong>Main Activity:</strong> Contient la recyclerView, C'est l'écran principale et d'acceuil</ol>
            <ol>- <strong>DetailActivity:</strong> Contient les <strong>fragment</strong> et les détails sur chaque personnage</ol>
            <ol>- <strong>ActivityLogo:</strong> Contient des informations sur le manga DBZ</ol>
            <ol>- <strong>ActivityTwo:</strong> Contient les <strong>videos youtube</strong>(Opening DBZ)</ol>
            <ol>- <strong>ActivityDev:</strong> Contient le nom, la photo et la classe du developeur de l'application</ol>
            <ol>- <strong>ActivityDetail:</strong> Contient un résumé du readme avec toutes les consignes respectés</ol>
    <li><strong>Fragments</strong></li>
    <li><strong>CollapsingToolbar</strong></li>
    <li><strong>GitFlow</strong></li>
    <li>Affichage d'une liste dans un <strong>RecyclerView</strong></li>
    <li>Affichage du détail d'un item de la liste</li>
    <li>Fonctions supplémentaires:</li>
    <ol>- Affichage en grille</ol>
        <ol>- Message qui indique l'item choisi</ol>
        <ol>- Icon</ol>
        <ol>- CircleImageView</ol>
        <ol><strong>- SearchBar</strong></ol>
        <ol>- <strong>NavigationBar</strong></ol>
        <ol>- <strong>VideoPlayer</strong></ol>
        <ol>- ImageButton</ol>
            <ol>- <strong>Cache</strong></ol>
</ul>        
<H2>Détails des fonctionnalitées:</H2>


<strong>L'icône</strong> de l'application est personnalisé:

<img src=https://github.com/IssamMlk/ProjetMobile4A/blob/master/Images/icon.jpg>

L'écran principale de l'application. On y trouve notamment la search bar, la navigationbar, la recyclerview avec l'appel API et le menu pour acceder aux activités Dev et Details.

<img src=https://github.com/IssamMlk/ProjetMobile4A/blob/master/Images/main.jpg height="600" width="300">

En cliquant sur un item, on arrive sur la detailActivity. On y trouve les fragments avec les informations sur chaques personnages et ses transformations.

<ul>
    <li>Ici, Son Goku adulte avec ses transformations</li>
    <img src=https://github.com/IssamMlk/ProjetMobile4A/blob/master/Images/detail_goku1.jpg height="600" width="300">
    <img src=https://github.com/IssamMlk/ProjetMobile4A/blob/master/Images/detail_goku2.jpg height="600" width="300">
    <li>Ici, Son Goku enfant avec ses transformations</li>
    <img src=https://github.com/IssamMlk/ProjetMobile4A/blob/master/Images/gokupetit.jpg height="600" width="300">
</ul>

Sur la mainActivity, on peut accéder via la NavigationDrawer à 2 autres activités:
<ul>
    <li>L'activityLogo qui donne plusieurs informations générale sur le manga DBZ, on peut aussi y accéder en cliquant sur le logo de Dragon Ball Z</li>
    <img src=https://github.com/IssamMlk/ProjetMobile4A/blob/master/Images/story.jpg height="600" width="300">
    <li>L'activitéTwo qui nous renvoie plusieurs videos youtube avec notamment les opening de DBZ</li>
    <img src=https://github.com/IssamMlk/ProjetMobile4A/blob/master/Images/video.jpg height="600" width="300">
</ul>    


De nouveau sur l'ecran d'acceuil, on peut via la toolbar. 
<ul>
    <li>Soit chercher un personnage avec la searchbar</li>
    <img src=https://github.com/IssamMlk/ProjetMobile4A/blob/master/Images/search.jpg height="600" width="300">
    <li>Soit accéder à l'activité Dev</li>
    <img src=https://github.com/IssamMlk/ProjetMobile4A/blob/master/Images/dev.jpg height="600" width="300">
    <li>Soit accéder à l'activité Detail</li>
    <img src=https://github.com/IssamMlk/ProjetMobile4A/blob/master/Images/menu_dev_detail.jpg height="600" width="300">
</ul>

J'ai moi même réaliser l'API

   
        
    
