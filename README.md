	"# Challenge" 
	Package model:
	class Transaction.java : notre modele
	class TransactionFilter.java : notre modele de filtrage
	class Page : pour la pagination
	
	Packge repository:
	interface TransactionRepository :qui contient les methodes 
	List<Transaction> findAll(); :pour afficher tous les transactions
	
		Transaction findById(Long id); :pour afficher la transaction en utilisant l'ID
	
		List<Transaction> findByAmount(BigDecimal amount); :pour afficher les transactions en utilisant le montant
	
		List<Transaction> findByMerchant(String merchant);:pour afficher les transactions en utilisant le merchant
	
		List<Transaction> findByStatus(String status);:pour afficher les transactions en utilisant la status
	
		Page<Transaction> getPaginatedTransactions(int page, int size); :pour afficher et faire la pagination de tous les transactions
	
		Page<Transaction> getPaginatedTransactionsMerchant(int page, int size, String merchant);:pour afficher et faire la pagination des transactions avec  un filtre sur le merchants
	
		Page<Transaction> getPaginatedTransactionsBYAmount(int page, int size, BigDecimal amount); :pour afficher et faire la pagination des transactions avec  un filtre sur le montant
	
		Page<Transaction> getPaginatedTransactionsBYAStatus(int page, int size, String status); :pour afficher et faire la pagination des transactions avec  un filtre sur la status
	
		List<Transaction> getSortedTransactions(String sortBy, String sortOrder); : pour trier les transaction par montant,merchant ou status 
	
	Package service:
	class TransactiService : pour implementer les methodes
	
	Package controller:
	class TransactionController: pour creer les API.
	
	
