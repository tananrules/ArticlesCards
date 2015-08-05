package com.example.tanan.articlescards;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;

/**
 * Created by tanan on 4/8/15.
 */
public class ArticlesFragment extends Fragment {
    CardArrayRecyclerViewAdapter cardArrayRecyclerViewAdapter;
    PostsObject mPostsObject;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cards_fragment, container, false);

        CardRecyclerView cardRecyclerView = (CardRecyclerView) view.findViewById(R.id.card_recycler_view);
        cardArrayRecyclerViewAdapter = new CardArrayRecyclerViewAdapter(getActivity(), getCards());
        cardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if(cardRecyclerView != null) {
            cardRecyclerView.setAdapter(cardArrayRecyclerViewAdapter);
        }
        return view;

    }

    public ArrayList<Card> getCards() {
        ArrayList<Card> cards = new ArrayList<>();
        return cards;
    }
}
