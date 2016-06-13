app.controller('clientCtrl', ['$scope', function($scope) {

	$scope.clients = [
		{
			"id" : "1",
			"nom": "Google",
			"logo":'img/google.png',
		},

		{
			"id": "2",
			"nom": "Microsoft",
			"logo" : 'images/microsoft.jpg', 
		},

		{
			"id": "3",
			"nom": "Carrefour",
			"logo" : 'images/carrefour.png', 
		},

		{
			"id": "4",
			"nom": "Mojang",
			"logo" : 'images/mojang.png', 
		},

	];
	
}]);

app.controller('userCtrl', ['$scope', '$http', '$resource', 'Restangular', function($scope,$http,$resource, Restangular) {
    $scope.ok=false;

    //$scope.clientCollection= {"nom": "Billiotte", "prenom": "Mickael"}

	$scope.submitUser = function() {
        var usr = new Object();
        usr.nom = $scope.nomUser;
        usr.prenom = $scope.prenomUser;
        usr.genre = $scope.genreUser;
        usr.dateNaissance =  $scope.dateNaissanceUser;
        usr.mail =  $scope.mailUser;

/*		$http.post("/userCtrl/addUser", {nom: $scope.nomUser, prenom: $scope.prenomUser, genre: $scope.genreUser, dateNaissance: $scope.dateNaissanceUser, mail: $scope.mailUser})
            .success(function(){console.log("User ajouté")})
            .error(function(){"Erreur ajout user"});*/

        $http.post("/userCtrl/addUser", usr)
            .success(function(){console.log("User ajouté");
                $scope.ok=true;
                $scope.okNom = usr.nom;
                $scope.okPrenom = usr.prenom;
                $scope.okGenre = usr.genre;
                $scope.okDate = usr.dateNaissance;
                $scope.okMail = usr.mail;
            })
            .error(function(){"Erreur ajout user"});


	};

    $scope.getListUsers = function() {
        $http.get("/userCtrl/getListUsers").success(function(response){
            console.log('Liste récupérée');
            $scope.collectionClient = response;
        }
        ).error(function(){'Erreur lors de la recherche'});
    };
    

    $scope.deleteUsers = function() {
        $http.delete('/userCtrl/deleteUsers').success(function(){console.log('Clients supprimés')}).error(function(){'Erreur lors de la suppression'});
    };

  

    $scope.deleteOne = function(id) {
        var User  = $resource('/userCtrl/deleteUser/:id',{id:id});
        var user = User.remove(function(){console.log('User destroyed')});

    };




    $scope.updateUser=  function(id,newMail) {
        var UserUpdate = $resource("/userCtrl/updateUser/:id/newInfo/:newMail",{id:'@id' ,newMail:'@newMail'},null);
        var userUpdate = UserUpdate.save({id:id,newMail:newMail});
    };



}]);


app.controller('companyCtrl', ['$scope', '$http', function($scope, $http){
    $scope.ok=false;

    $scope.submitCompany = function() {
        var company = new Object();
        company.nom = $scope.nomSociete;
        company.numero = $scope.numeroSociete;
        company.nb = $scope.nbEmploye;
        company.email = $scope.emailSociete;
        company.loc = $scope.localisationSociete;

        console.log($scope.nomSociete);

        $http.post('/companyCtrl/addCompany', company)
            .success(function(){
                $scope.ok=true;
                console.log('Entreprise ajoutée');
                $scope.okNom= company.nom;
                $scope.okNum =company.numero;
                $scope.okNb = company.nb;
                $scope.okMail = company.email;
                $scope.okLoc = company.loc;
            }
            ).error(function(){console.log('Erreur lors de la transaction')});
    }

}]);

app.controller('descriptionCtrl', ['$scope', function($scope) {
	$scope.afficherDescription = false;
}]);