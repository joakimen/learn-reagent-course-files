(ns giggin.components.gigs
  (:require [giggin.helpers :refer [format-price]]
            [giggin.state :as state]))

(defn gigs []
  (let [add-to-order #(swap! state/orders update % inc)]
    [:main
     [:div.gigs
      (for [{:keys [id title desc img price]} (vals @state/gigs)]
        [:div.gig {:key id}
         [:img.gig__artwork {:src img :alt "alt"}]
         [:div.gig__body
          [:div.gig__title
           [:div.btn.btn--primary.float--right.tooltip
            {:data-tooltip "Add to order"
             :on-click #(add-to-order id)}
            [:i.icon.icon--plus]] title]
          [:p.gig__price (format-price price)]
          [:p.gig__desc desc]]])]]))
