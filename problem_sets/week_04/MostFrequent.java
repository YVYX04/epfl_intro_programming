class MostFrequent {

    public static void main(String[] args) {
        int[] tab1 = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7, 6};
        int taille = tab1.length;

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        int mostOccurring = tab1[0];
        int max = -1;
        int nOccurences = 0;

        for(int i = 0; i < taille; ++i)
        {
            int k = tab1[i];
            nOccurences = 0;
            
            if(k == mostOccurring && k != tab1[0]) continue;
            for(int j = 0; j < taille; ++j)
            {
                if(tab1[j] == k) ++nOccurences;
            }

            if(nOccurences > max)
            {
                max = nOccurences;
                mostOccurring = k;
            }
        }

        // output
        System.out.println("Le nombre le plus frequent dans le tableau est le :");
        System.out.println(mostOccurring + " (" + max + " x)");

        return;

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}
